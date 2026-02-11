package com.desafio.starkbank.boundary.dto;

public record WebhookEventOutputDTO(
        String eventId,
        String subscription,
        String invoiceId,
        String invoiceLogType,
        Number amountReceivedInCents,
        Integer feeInCents
) {}
