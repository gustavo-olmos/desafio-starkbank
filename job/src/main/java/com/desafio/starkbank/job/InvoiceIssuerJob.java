package com.desafio.starkbank.job;

import com.desafio.starkbank.boundary.usecases.InvoiceEmitterUseCase;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceIssuerJob
{
    private final InvoiceEmitterUseCase useCase;

    @Scheduled(cron = "0 */3 * * *")
    public final void invoiceIssueJob() {
        useCase.processInvoiceIssueJob();
    }
}
