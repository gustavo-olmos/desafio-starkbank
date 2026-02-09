package com.desafio.starkbank;

import com.desafio.starkbank.data.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceJpaRepository extends JpaRepository<InvoiceModel, Long>
{
}
