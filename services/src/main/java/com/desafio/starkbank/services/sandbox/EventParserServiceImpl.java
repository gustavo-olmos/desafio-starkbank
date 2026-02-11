package com.desafio.starkbank.services.sandbox;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.boundary.service.EventParserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@AllArgsConstructor
public class EventParserServiceImpl implements EventParserService
{
    private final ObjectMapper objectMapper;

    @Override
    public WebhookEventOutputDTO parseInvoiceEvent(String content, String signature) {
        return objectMapper.readValue(content, WebhookEventOutputDTO.class);
    }
}
