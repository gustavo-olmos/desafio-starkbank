package com.desafio.starkbank.boundary.service;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.starkbank.Event;

public interface EventParserService
{
    WebhookEventOutputDTO parseInvoiceEvent(String eventMessage, String signature);
}
