package com.desafio.starkbank.usecase;

import com.desafio.starkbank.boundary.clients.TransferClient;
import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.boundary.exception.WebhookEventHandlerException;
import com.desafio.starkbank.boundary.repository.PaymentReceiptRepository;
import com.desafio.starkbank.boundary.repository.WebhookEventRepository;
import com.desafio.starkbank.boundary.service.EventParserService;
import com.desafio.starkbank.boundary.usecases.WebhookUseCase;
import com.desafio.starkbank.domain.data.InvoiceTransactionDomain;
import com.desafio.starkbank.domain.exception.InsufficientFundsForTransferException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class WebhookUseCaseImpl implements WebhookUseCase {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final TransferClient transferClient;
    private final EventParserService parserService;
    private final WebhookEventRepository eventRepository;
    private final PaymentReceiptRepository receiptRepository;

    /**
     * Orquestração: <br>
     * 1) valida/parseia (Event)  <br>
     * 2) idempotência (salva eventId UNIQUE) <br>
     * 3) filtra somente invoice paga <br>
     * 4) calcula net (valor - taxa) <br>
     * 5) cria Transfer <br>
     * 6) persiste recibo/auditoria <br>
     */
    @Override
    @Transactional
    public void handle(String eventMessage, String signature) {
        try {
            LOGGER.info("[WebhookUseCaseImpl.handle] Evento recebido, eventMessage = {}", eventMessage);

            // 1
            WebhookEventOutputDTO eventDTO = parserService.parseInvoiceEvent(eventMessage, signature);
            if (eventDTO == null) return;

            // 2
            eventRepository.save(eventDTO);

            // 3
            InvoiceTransactionDomain transaction = new InvoiceTransactionDomain(
                    eventDTO.amountReceivedInCents().longValue(),
                    eventDTO.feeInCents().longValue(),
                    eventDTO.invoiceLogType()
            );

            if (!transaction.isEligibleForTransfer(eventDTO.invoiceLogType())) {
                LOGGER.info("[Webhook] Evento com status {} não elegível.", eventDTO.invoiceLogType());
                return;
            }

            // 4
            long amountToTransfer = transaction.calculateNetValue();

            // 5
            String transferId = transferClient.createTransfer(amountToTransfer);

            // 6
            receiptRepository.save(eventDTO, transferId, amountToTransfer);
        } catch (InsufficientFundsForTransferException ex) {
            LOGGER.warn("[Webhook] Transferência abortada: {}", ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
