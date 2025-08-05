package com.tsinjo.hei.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record Payment(
        String id,
        String pspPaymentId,
        PspType pspType,
        Instant lastPspVerificationInstant,
        LocalDateTime date,
        double amount,
        PaymentStatus status
) {}
