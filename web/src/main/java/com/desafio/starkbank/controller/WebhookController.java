package com.desafio.starkbank.controller;

import com.desafio.starkbank.boundary.usecases.WebhookUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/webhook")
@Tag(name = "Webhook", description = "Operações para webhook de recebimento de fatura")
public class WebhookController
{
    private final WebhookUseCase useCase;

    @PostMapping
    @Operation(summary = "Adiciona lembrete")
    public ResponseEntity<Void> receive(
            @RequestBody String eventMessage,
            @RequestHeader(name = "Digital-Signature", required = false) String signature
    ) {
        useCase.handle(eventMessage, signature);

        return ResponseEntity.ok().build();
    }
}
