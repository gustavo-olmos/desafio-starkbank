package com.desafio.starkbank.boundary.dto;

import java.math.BigDecimal;

public record InvoiceEventInputDTO(
        String type,
        String subscription,
        Long eventId,
        Long invoiceId,
        BigDecimal amountReceived,
        BigDecimal fee
) {}
