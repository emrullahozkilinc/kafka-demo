package com.emr.stockservice.data.kafka_payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductStockDropPayload implements Serializable {
    private UUID basketId;
    private UUID productId;
    private UUID userId;
    private BigDecimal amount;
}
