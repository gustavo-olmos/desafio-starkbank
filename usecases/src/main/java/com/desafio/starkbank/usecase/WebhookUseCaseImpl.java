package com.desafio.starkbank.usecase;

import com.desafio.starkbank.boundary.WebhookUseCase;
import com.desafio.starkbank.boundary.clients.StarkbankSandboxClient;
import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.boundary.repository.PaymentReceiptRepository;
import com.desafio.starkbank.boundary.repository.WebhookEventRepository;
import com.desafio.starkbank.boundary.service.EventParserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class WebhookUseCaseImpl implements WebhookUseCase
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final EventParserService starkbankService;
    private final StarkbankSandboxClient sandboxClient;
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

            WebhookEventOutputDTO parsedEvent = starkbankService.parseInvoiceEvent(eventMessage, signature);  /* Passo 1 */
            if (parsedEvent == null || parsedEvent.subscription() == null) return;
            if (!"invoice".equals(parsedEvent.subscription())) return;

            eventRepository.save(parsedEvent); /* Passo 2 */

            //TODO: Definir um Enum para o event.type()
            if (!"paid".equals(parsedEvent.type())) return; /* Passo 3 */

            long received = parsedEvent.amountReceived().longValue();
            long fee = parsedEvent.fee().longValue();
            long net = Math.max(0, received - fee); /* Passo 4 */

            UUID transferId = sandboxClient.createTransfer(net); /* Passo 5 */

            receiptRepository.save(parsedEvent, transferId, received, net); /* Passo 6 */
        } catch (Exception e) {
            //TODO: Definir uma exception própria para esse ponto e colocar uma mensagem de erro aqui
            throw new RuntimeException(e);
        }
    }
}
