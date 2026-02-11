package com.desafio.starkbank.boundary.repository;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;

import java.util.UUID;

public interface PaymentReceiptRepository
{
    void save(WebhookEventOutputDTO receiptOutputDTO, UUID transferId, Long received, Long net);
}
