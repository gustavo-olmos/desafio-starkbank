package com.desafio.starkbank.boundary.repository;

public interface WebhookRepository
{
    Void save( String eventMessage );
}
