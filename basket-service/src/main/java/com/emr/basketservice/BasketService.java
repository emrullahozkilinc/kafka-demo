package com.emr.basketservice;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void addToBasket() {
        kafkaTemplate.send("product-stock-drop-topic", "7f13fa9a-c755-4c4d-8b25-5e7ba8440074");
    }
}
