package com.desafio.starkbank.client.sandbox.invoice;

import com.desafio.starkbank.boundary.clients.InvoiceClient;
import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;
import com.desafio.starkbank.boundary.exception.BusinessException;
import com.desafio.starkbank.boundary.exception.InvoiceCreationException;
import com.starkbank.Invoice;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class InvoiceStarkbankClientImpl implements InvoiceClient {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void createInvoices(List<InvoiceCreationRequestDTO> bodyRequests) {
        LOGGER.info("[InvoiceEmitterUseCaseImpl.createInvoices] Iniciando produção de {} faturas.", bodyRequests.size());

        try {
            List<Invoice> invoices = bodyRequests.stream()
                    .map(this::convertToInvoice)
                    .toList();

            Invoice.create(invoices);
        } catch (Exception ex) {
            LOGGER.error("Erro ao processar lote de faturas. ", ex);
            throw new InvoiceCreationException("Falha ao emitir faturas em lote. " + ex.getMessage());
        }
    }

    private Invoice convertToInvoice(InvoiceCreationRequestDTO request) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("amount", request.amount());
            params.put("name", request.name());
            params.put("taxId", request.taxId());
            params.put("due", request.dueDate().toString());
            params.put("expiration", request.expiration());

            if (request.tags() != null) {
                params.put("tags", request.tags().toArray(new String[0]));
            }

            return new Invoice(params);
        } catch (Exception ex) {
            LOGGER.error("Falha na conversão dos parâmetros para Invoice", ex);
            throw new BusinessException("Erro ao converter DTO para Invoice: " + ex.getMessage());
        }
    }
}
