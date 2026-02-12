package com.desafio.starkbank.client.sandbox.transfer;

import com.desafio.starkbank.boundary.clients.TransferClient;
import com.desafio.starkbank.boundary.exception.TransferFailedException;
import com.starkbank.Transfer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TransferStarkbankClientImpl implements TransferClient
{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String createTransfer(Long net) {

        try {
            Transfer transfer = new Transfer(Map.of(
                    "amount", net,
                    "bankCode", "20018183",
                    "branchCode", "0001",
                    "accountNumber", "6341320293482496",
                    "name", "Stark Bank S.A.",
                    "taxId", "20.018.183/0001-80",
                    "accountType", "payment"
            ));

            List<Transfer> transfers = Transfer.create(List.of(transfer));
            Transfer createdTransfer = transfers.getFirst();

            LOGGER.info("[TransferStarkbankClientImpl.createTransfer] Transferência realizada! transferId = {}", createdTransfer.id);

            return createdTransfer.id;
        } catch (Exception ex) {
            throw new TransferFailedException("Falha ao tentar realizar transferência! " + ex.getMessage());
        }
    }

}
