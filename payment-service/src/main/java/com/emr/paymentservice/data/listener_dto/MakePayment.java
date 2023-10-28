package com.emr.paymentservice.data.listener_dto;

import java.math.BigDecimal;
import java.util.UUID;

public record MakePayment(UUID userId, BigDecimal amount) {
}
