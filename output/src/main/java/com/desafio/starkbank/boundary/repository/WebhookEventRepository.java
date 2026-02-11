package com.desafio.starkbank.boundary.repository;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;

public interface WebhookEventRepository
{
    void save(WebhookEventOutputDTO output);
}
