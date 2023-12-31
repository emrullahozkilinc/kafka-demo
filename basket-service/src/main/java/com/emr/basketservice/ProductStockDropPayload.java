package com.emr.basketservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductStockDropPayload {
    private UUID basketId;
    private UUID productId;
    private UUID userId;
    private BigDecimal amount;
}
