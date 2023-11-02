package com.emr.paymentservice.service;

import com.emr.paymentservice.data.dbmodel.Bank;
import com.emr.paymentservice.data.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;

    public BigDecimal getBalance(UUID userId) {
        return bankRepository.findByUserId(userId).orElseGet(() -> Bank.builder().balance(BigDecimal.ZERO).build()).getBalance();
    }

    public void dropUserBalance(UUID userId, BigDecimal amount) {
        Bank bank = bankRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        if (getBalance(userId).compareTo(bank.getBalance()) >= 0) {
            log.info("{} idli userdan {} miktarında hesabından düşüldü.", userId, amount);
            bank.setBalance(bank.getBalance().subtract(amount));
            bankRepository.save(bank);
        } else {
            throw new RuntimeException("Insufficient balance!");
        }
    }
}
