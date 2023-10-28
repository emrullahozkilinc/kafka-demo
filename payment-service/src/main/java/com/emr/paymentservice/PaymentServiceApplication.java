package com.emr.paymentservice;

import com.emr.paymentservice.data.dbmodel.Bank;
import com.emr.paymentservice.data.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
/*@RequiredArgsConstructor*/
public class PaymentServiceApplication {

/*
    private final BankRepository bankRepository;
*/

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {
        Bank bank = new Bank();
        bank.setBalance(new BigDecimal(19000));
        bank.setUserId(UUID.fromString("afb13a92-f81e-41c0-978d-666e7dc9a784"));
        bankRepository.save(bank);
    }*/
}
