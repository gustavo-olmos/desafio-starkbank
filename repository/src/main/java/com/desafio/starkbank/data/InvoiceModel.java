package com.desafio.starkbank.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice")
public class InvoiceModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cor", unique = true, nullable = false)
    private String cor;

    @Column(name = "fatorOrdem", unique = true, nullable = false)
    private int fatorOrdem;
}
