package com.desafio.starkbank.client.sandbox;

import com.desafio.starkbank.boundary.clients.StarkbankSandboxClient;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class StarkbankSandboxClientImpl implements StarkbankSandboxClient
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //private final RestTemplate restTemplate;

    @Override
    public UUID createTransfer(Long net) {
        try {
            //TODO: Um log aqui
            /*
                AQUI você usa o SDK real para criar a Transfer com os dados do enunciado:

                Transfer transfer = Transfer.create(Map.of(
                  "amount", netAmountInCents,
                  "bankCode", "20018183",
                  "branchCode", "0001",
                  "accountNumber", "6341320293482496",
                  "name", "Stark Bank S.A.",
                  "taxId", "20.018.183/0001-80",
                  "accountType", "payment"
                ));
                return transfer.id;
            */
            return UUID.fromString("cd743a26-67a6-4185-80f0-d4b7d28e6f81");
        } catch (Exception e) {
            //TODO: Exception específica para esse carinha aqui + um log
            throw new RuntimeException(e);
        }
    }
}
