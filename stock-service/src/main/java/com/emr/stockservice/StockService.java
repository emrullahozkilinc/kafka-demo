package com.emr.stockservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {

    @KafkaListener(topics = "product-stock-drop-topic", groupId = "1")
    public void dropStock() {
        log.info("{} idli ürün stoktan 1 düşürüldü.");
    }
}
