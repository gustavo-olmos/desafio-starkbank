package com.desafio.starkbank.boundary.exception;

public class WebhookEventHandlerException extends RuntimeException
{
    public WebhookEventHandlerException(String message) {
        super(message);
    }
}
