package com.desafio.starkbank.boundary.repository;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;

public interface PaymentReceiptRepository
{
    void save(WebhookEventOutputDTO receiptOutputDTO, String transferId, Long net);
}
