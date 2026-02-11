package com.desafio.starkbank.domain.exception;

public class InsufficientFundsForTransferException extends Exception {
    public InsufficientFundsForTransferException(String message) {
        super(message);
    }
}
