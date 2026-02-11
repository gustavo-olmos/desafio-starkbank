package com.desafio.starkbank.domain.data;

import com.desafio.starkbank.domain.enums.InvoicesTransferEligibleStatuses;
import com.desafio.starkbank.domain.exception.InsufficientFundsForTransferException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class InvoiceTransactionDomain
{
    private long amountReceived;
    private long fee;
    private String status;

    /**
     * Regra de Negócio: Calcula o valor líquido.
     * Garante que nunca retornaremos um valor negativo para a transferência.
     */
    public long calculateNetValue() throws InsufficientFundsForTransferException {
        long net = this.amountReceived - this.fee;

        if (net <= 0) {
            throw new InsufficientFundsForTransferException(
                    String.format("Saldo insuficiente para transferência. Recebido: %d, Taxa: %d",
                            this.amountReceived, this.fee)
            );
        }
        return net;
    }

    /**
     * Regra de Negócio: Verifica se o status permite transferência.
     */
    public boolean isEligibleForTransfer(String logType) {
        return logType != null &&
                Arrays.stream(InvoicesTransferEligibleStatuses.values())
                        .map(InvoicesTransferEligibleStatuses::name)
                        .toList()
                        .contains(logType.toUpperCase());
    }
}
