package com.tsinjo.hei.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record Payment(
        UUID id,
        LocalDateTime date,
        double amount,
        PaymentStatus status
) {}
