package com.emr.paymentservice.service;

import com.emr.paymentservice.data.kafka_payload.MakePayment;
import com.emr.paymentservice.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BankService bankService;

    @KafkaListener(topics = "make-payment-topic", groupId = "1", contentTypeConverter = "jsonConverter")
    public void makePayment(MakePayment makePayment) {
        bankService.dropUserBalance(makePayment.userId(), makePayment.amount());
    }
}
