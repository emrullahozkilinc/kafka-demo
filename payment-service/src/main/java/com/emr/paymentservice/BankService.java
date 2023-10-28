package com.emr.paymentservice;

import com.emr.paymentservice.data.dbmodel.Bank;
import com.emr.paymentservice.data.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public BigDecimal getBalance(UUID userId) {
        return bankRepository.findByUserId(userId).orElseGet(() -> Bank.builder().balance(BigDecimal.ZERO).build()).getBalance();
    }

    public void dropUserBalance(UUID userId, BigDecimal amount) {
        Bank bank = bankRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        if (getBalance(userId).compareTo(bank.getBalance()) >= 0) {
            bank.setBalance(bank.getBalance().subtract(amount));
        } else {
            throw new RuntimeException("Unsufficient balance!");
        }
    }
}
