package com.desafio.starkbank.boundary.dto;

import java.math.BigDecimal;

public record WebhookEventOutputDTO(
        Long eventId,
        Long invoiceId,
        String type,
        String subscription,
        BigDecimal amountReceived,
        BigDecimal fee
) {}
