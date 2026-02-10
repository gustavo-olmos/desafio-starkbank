package com.desafio.starkbank.boundary;

public interface WebhookUseCase
{
    Void process( String eventMessage );
}
