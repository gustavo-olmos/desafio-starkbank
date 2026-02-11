package com.desafio.starkbank.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_payment_receipt")
public class PaymentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_event", nullable = false)
    private Long eventId;

    @Column(name = "id_invoice", nullable = false)
    private Long invoiceId;

    @Column(name = "id_transfer", nullable = false)
    private UUID transferId;

    @Column(name = "nr_payment_received", nullable = false)
    private BigDecimal receivedAmount;

    @Column(name = "nr_fee", nullable = false)
    private BigDecimal feeAmount;

    @Column(name = "nr_net", nullable = false)
    private BigDecimal netAmount;

    @Column(name = "dh_created_at", nullable = false)
    private OffsetDateTime createdAt;

}
