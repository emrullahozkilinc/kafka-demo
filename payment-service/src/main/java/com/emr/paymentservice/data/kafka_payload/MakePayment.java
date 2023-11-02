package com.emr.paymentservice.data.kafka_payload;

import java.math.BigDecimal;
import java.util.UUID;

public record MakePayment(UUID basketId, UUID userId, BigDecimal amount) {
}
