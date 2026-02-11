package com.desafio.starkbank.boundary.exception;

public class WebhookEventHandlerException extends RuntimeException
{
    //TODO: ver como coloca uns codes para exception
    public WebhookEventHandlerException(String message) {
        super(message);
    }
}
