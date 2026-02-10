package com.desafio.starkbank.controller;

import com.desafio.starkbank.boundary.WebhookUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/webhook")
@Tag(name = "Webhook", description = "Operações para webhook de recebimento de fatura")
public class WebhookController
{
    private final WebhookUseCase useCase;

    @PostMapping
    @Operation(summary = "Adiciona lembrete")
    public ResponseEntity<Void> salvar(@RequestBody String eventMessage) {
        useCase.process(eventMessage);

        return ResponseEntity.ok().build();
    }
}
