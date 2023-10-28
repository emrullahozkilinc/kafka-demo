package com.emr.basketservice;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final KafkaTemplate<String, ProductStockDropPayload> kafkaTemplate;

    public void addToBasket() {
        kafkaTemplate.send("product-stock-drop-topic",
                new ProductStockDropPayload(
                        UUID.randomUUID(),
                        UUID.fromString("5eeaae8e-e873-44a9-8615-2ca6b5a46dd2"),
                        UUID.fromString("afb13a92-f81e-41c0-978d-666e7dc9a784"),
                        new BigDecimal(500)
                )
        );
    }
}
