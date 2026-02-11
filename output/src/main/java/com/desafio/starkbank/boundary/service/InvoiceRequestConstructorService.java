package com.desafio.starkbank.boundary.service;

import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;

import java.util.List;

public interface InvoiceRequestConstructorService
{
    List<InvoiceCreationRequestDTO> constructInvoiceBodyRequest(int quantity);
}
