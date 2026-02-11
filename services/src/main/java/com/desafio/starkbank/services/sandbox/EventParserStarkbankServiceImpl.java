package com.desafio.starkbank.services.sandbox;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.boundary.service.EventParserService;
import com.starkbank.Event;
import com.starkbank.Invoice;
import org.springframework.stereotype.Component;

@Component
public class EventParserStarkbankServiceImpl implements EventParserService
{
    @Override
    public WebhookEventOutputDTO parseInvoiceEvent(String eventMessage, String signature) {
        if (eventMessage == null || eventMessage.isBlank()) return null;

        try {
            Event event = Event.parse(eventMessage, signature);
            if (!"invoice".equals(event.subscription)) return null;

            Event.InvoiceEvent invoiceEvent = (Event.InvoiceEvent) event;
            Invoice invoice = invoiceEvent.log.invoice;

            return new WebhookEventOutputDTO(
                    event.id,
                    event.subscription,
                    invoiceEvent.log.type,
                    invoice.id,
                    (invoice.amount == null) ? 0 : invoice.amount,
                    (invoice.fee == null) ? 0 : invoice.fee
            );
        } catch (Exception e) {
            // TODO: Exception específica
            throw new RuntimeException(e);
        }
    }
}
