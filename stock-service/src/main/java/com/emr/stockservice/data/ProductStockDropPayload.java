package com.emr.stockservice.data;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductStockDropPayload(UUID basketId, UUID productId, UUID userId, BigDecimal amount) {
}
