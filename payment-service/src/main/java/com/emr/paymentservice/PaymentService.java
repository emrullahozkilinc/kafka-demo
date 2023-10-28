package com.emr.paymentservice;

import com.emr.paymentservice.data.listener_dto.MakePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BankService bankService;

    @KafkaListener(topics = "make-payment-topic", groupId = "1")
    public void makePayment(MakePayment makePayment) {
        bankService.dropUserBalance(makePayment.userId(), makePayment.amount());
    }
}
