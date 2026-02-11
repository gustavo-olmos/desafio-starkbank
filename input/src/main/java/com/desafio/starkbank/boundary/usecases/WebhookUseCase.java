package com.desafio.starkbank.boundary.usecases;

public interface WebhookUseCase
{
    void handle(String eventMessage, String signature);
}
