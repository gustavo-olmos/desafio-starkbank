package com.desafio.starkbank.usecase;

public interface WebhookUseCase
{
    Void process( String eventMessage );
}
