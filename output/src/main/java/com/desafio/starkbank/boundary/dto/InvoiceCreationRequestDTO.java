package com.desafio.starkbank.boundary.dto;

import java.time.LocalDate;
import java.util.List;

public record InvoiceCreationRequestDTO(
        Integer amount,
        String name,
        String taxId,
        LocalDate dueDate,
        Integer expiration,
        List<String> tags
) {}