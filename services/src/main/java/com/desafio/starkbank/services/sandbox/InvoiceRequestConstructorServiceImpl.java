package com.desafio.starkbank.services.sandbox;

import com.desafio.starkbank.boundary.dto.InvoiceCreationRequestDTO;
import com.desafio.starkbank.boundary.service.InvoiceRequestConstructorService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@Component
public class InvoiceRequestConstructorServiceImpl implements InvoiceRequestConstructorService
{
    @Override
    public List<InvoiceCreationRequestDTO> constructInvoiceBodyRequest(int quantity) {
        Random random = new Random();
        return IntStream.range(0, quantity)
                .mapToObj(i -> new InvoiceCreationRequestDTO(
                        (random.nextInt(900) + 100) * 100,
                        "User " + UUID.randomUUID(),
                        "012.345.678-90",
                        LocalDate.now().plusDays(1),
                        3600,
                        List.of("challenge", "auto-generated")
                ))
                .toList();
    }
}
