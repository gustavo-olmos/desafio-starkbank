package com.desafio.starkbank.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "tb_invoice")
public class InvoiceModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uk_event", unique = true, nullable = false)
    private Long eventId;

    @Column(name = "dh_created_at", nullable = false)
    private OffsetDateTime createdAt;
}
