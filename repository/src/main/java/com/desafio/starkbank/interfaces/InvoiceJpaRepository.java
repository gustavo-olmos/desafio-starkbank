package com.desafio.starkbank.interfaces;

import com.desafio.starkbank.data.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceJpaRepository extends JpaRepository<InvoiceModel, Long>
{
    boolean existsByEventId(String eventId);
}
