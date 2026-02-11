package com.desafio.starkbank.client.sandbox.invoice;

import com.desafio.starkbank.boundary.clients.InvoiceClient;
import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;
import com.starkbank.Invoice;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceStarkbankClientImpl implements InvoiceClient {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void createInvoices(List<InvoiceCreationRequestDTO> bodyRequests) {
        LOGGER.info("[InvoiceEmitterUseCaseImpl.processInvoiceIssueJob] Job para produção de faturas acionado!");

        List<Invoice> invoices = new ArrayList<>();

        try {
            for (InvoiceCreationRequestDTO request : bodyRequests) {
                invoices.add(new Invoice(
                                new HashMap<>() {{
                                    put("amount", request.amount());
                                    put("name", request.name());
                                    put("taxId", request.taxId());
                                    put("due", request.dueDate().toString());
                                    put("expiration", request.expiration());
                                    put("tags", request.tags());
                                }}
                        )
                );
            }
            Invoice.create(invoices);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
