package com.desafio.starkbank.boundary.service;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;

public interface EventParserService
{
    WebhookEventOutputDTO parseInvoiceEvent(String content, String signature);
}
