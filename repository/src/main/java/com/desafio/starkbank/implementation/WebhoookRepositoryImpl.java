package com.desafio.starkbank.implementation;

import com.desafio.starkbank.boundary.repository.WebhookRepository;
import com.desafio.starkbank.interfaces.InvoiceJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WebhoookRepositoryImpl implements WebhookRepository
{
    private final InvoiceJpaRepository jpaRepository;

    @Override
    public Void save( String eventMessage ) {
        //jpaRepository.save( eventMessage );

        return null;
    }
}
