package com.emr.stockservice.data;

import java.math.BigDecimal;
import java.util.UUID;

public record MakePayment(UUID basketId, UUID userId, BigDecimal amount) {
}
