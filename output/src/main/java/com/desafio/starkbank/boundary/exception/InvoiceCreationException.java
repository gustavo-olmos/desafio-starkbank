package com.desafio.starkbank.boundary.exception;

public class InvoiceCreationException extends RuntimeException {
    public InvoiceCreationException(String message) {
        super(message);
    }
}
