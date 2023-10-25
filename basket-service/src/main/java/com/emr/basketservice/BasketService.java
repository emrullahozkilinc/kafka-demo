package com.emr.basketservice;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void addToBasket() {

        kafkaTemplate.send("product-stock-drop-topic", "1");
    }
}
