package com.emr.stockservice;

import com.emr.stockservice.data.kafka_payload.MakePayment;
import com.emr.stockservice.data.kafka_payload.ProductStockDropPayload;
import com.emr.stockservice.data.Stock;
import com.emr.stockservice.data.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final KafkaTemplate<String, MakePayment> kafkaTemplate;

    @KafkaListener(topics = "product-stock-drop-topic", groupId = "1", contentTypeConverter = "jsonConverter")
    @Transactional
    public void dropStock(ProductStockDropPayload payload) {
        dropStockFromDb(payload.getProductId());
        makePayment(new MakePayment(payload.getBasketId(), payload.getUserId(), payload.getAmount()));
        log.info("{} idli ürün stoktan 1 düşürüldü.", payload.getProductId());
    }

    private void makePayment(MakePayment makePayment) {
        kafkaTemplate.send("make-payment-topic", makePayment);
    }

    public void dropStockFromDb(UUID productId) {
        Optional<Stock> product = stockRepository.findByProductId(productId);
        product.ifPresentOrElse(checkProductAndDropStock(), throwIfProductNotFound());
        stockRepository.save(product.get());
    }

    private Runnable throwIfProductNotFound() {
        return () -> {throw new RuntimeException("Product not found");};
    }

    Consumer<Stock> checkProductAndDropStock() {
        return p -> {
            if (p.getAmount()>0) {
                p.setAmount(p.getAmount() - 1);
            }else {
                throw new RuntimeException("Insufficient stock with productId: " + p.getProductId());
            }
        };
    }
}
