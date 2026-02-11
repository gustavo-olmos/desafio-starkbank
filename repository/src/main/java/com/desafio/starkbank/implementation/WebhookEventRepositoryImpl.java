package com.desafio.starkbank.implementation;

import com.desafio.starkbank.boundary.repository.WebhookEventRepository;
import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.data.model.InvoiceModel;
import com.desafio.starkbank.interfaces.InvoiceJpaRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@AllArgsConstructor
public class WebhookEventRepositoryImpl implements WebhookEventRepository
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final InvoiceJpaRepository jpaRepository;

    @Override
    public void save(WebhookEventOutputDTO output) {
        if (jpaRepository.existsByEventId(output.eventId())) {
            LOGGER.error("[WebhookEventRepositoryImpl.save] Evento duplicado. eventId = {}", output.eventId());
            return;
        }

        InvoiceModel model = new InvoiceModel();
        model.setEventId(output.eventId());
        model.setCreatedAt(OffsetDateTime.now());

        jpaRepository.save(model);
    }
}
