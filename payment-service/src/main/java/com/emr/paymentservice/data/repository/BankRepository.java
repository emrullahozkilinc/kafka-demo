package com.emr.paymentservice.data.repository;

import com.emr.paymentservice.data.dbmodel.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {

    Optional<Bank> findByUserId(UUID userId);

}
