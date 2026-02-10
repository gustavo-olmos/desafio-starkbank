package com.desafio.starkbank.usecase;

import com.desafio.starkbank.boundary.WebhookUseCase;
import com.desafio.starkbank.boundary.repository.WebhookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebhookUseCaseImpl implements WebhookUseCase
{
    private final WebhookRepository repository;

    @Override
    public Void process(String eventMessage) {
        //faz uns calculos ai descontando taxa
        repository.save(eventMessage);

        return null;
    }
}
