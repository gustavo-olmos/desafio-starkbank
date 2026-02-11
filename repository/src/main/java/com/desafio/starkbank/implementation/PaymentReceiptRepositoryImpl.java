package com.desafio.starkbank.implementation;

import com.desafio.starkbank.boundary.dto.WebhookEventOutputDTO;
import com.desafio.starkbank.boundary.repository.PaymentReceiptRepository;
import com.desafio.starkbank.data.model.PaymentModel;
import com.desafio.starkbank.interfaces.PaymentReceiptJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PaymentReceiptRepositoryImpl implements PaymentReceiptRepository
{
    private final PaymentReceiptJpaRepository jpaRepository;

    @Override
    public void save(WebhookEventOutputDTO receiptOutputDTO, UUID transferId, Long received, Long net) {
        PaymentModel payment = new PaymentModel();
        payment.setEventId(receiptOutputDTO.eventId());
        payment.setInvoiceId(receiptOutputDTO.invoiceId());
        payment.setTransferId(transferId);
        payment.setReceivedAmount(BigDecimal.valueOf(received));
        payment.setFeeAmount(receiptOutputDTO.fee());
        payment.setNetAmount(BigDecimal.valueOf(net));
        payment.setCreatedAt(OffsetDateTime.now());

        jpaRepository.save(payment);
    }
}
