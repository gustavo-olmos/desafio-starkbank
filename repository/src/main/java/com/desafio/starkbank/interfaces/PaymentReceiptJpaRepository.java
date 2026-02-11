package com.desafio.starkbank.interfaces;

import com.desafio.starkbank.data.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReceiptJpaRepository extends JpaRepository<PaymentModel, Long>
{
}
