package com.desafio.starkbank.repository;

public interface WebhookRepository
{
    Void save( String eventMessage );
}
