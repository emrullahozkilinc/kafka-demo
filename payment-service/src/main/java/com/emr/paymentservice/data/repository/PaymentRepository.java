package com.emr.paymentservice.data.repository;

import com.emr.paymentservice.data.dbmodel.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> { }
