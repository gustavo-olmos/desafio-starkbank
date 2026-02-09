package com.desafio.starkbank;

import com.desafio.starkbank.repository.WebhookRepository;
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
