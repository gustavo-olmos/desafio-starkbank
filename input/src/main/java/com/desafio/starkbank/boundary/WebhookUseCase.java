package com.desafio.starkbank.boundary;

public interface WebhookUseCase
{
    void handle(String eventMessage, String signature);
}
