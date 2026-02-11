package com.desafio.starkbank.usecase;

import com.desafio.starkbank.boundary.clients.InvoiceClient;
import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;
import com.desafio.starkbank.boundary.service.InvoiceRequestConstructorService;
import com.desafio.starkbank.boundary.usecases.InvoiceEmitterUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class InvoiceEmitterUseCaseImpl implements InvoiceEmitterUseCase
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final InvoiceClient invoiceClient;
    private final InvoiceRequestConstructorService constructorService;

    @Override
    public void processInvoiceIssueJob() {
        LOGGER.info("[InvoiceEmitterUseCaseImpl.processInvoiceIssueJob] Job para produção de faturas acionado!");

        Random random = new Random();
        List<InvoiceCreationRequestDTO> bodyReq = constructorService.constructInvoiceBodyRequest(random.nextInt(8, 12));

        invoiceClient.createInvoices(bodyReq);
    }
}
