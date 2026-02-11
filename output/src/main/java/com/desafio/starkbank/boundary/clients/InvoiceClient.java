package com.desafio.starkbank.boundary.clients;

import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;

import java.util.List;

public interface InvoiceClient
{
    void createInvoices(List<InvoiceCreationRequestDTO> bodyRequests);
}
