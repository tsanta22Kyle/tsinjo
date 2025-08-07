package com.tsinjo.hei.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsinjo.hei.model.PaymentStatus;
import java.time.Instant;

public record VolaPayment(
    String id,
    @JsonProperty("pspPayment") VolaPspPayment pspPayment,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC") Instant creationInstant,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant lastPspVerificationInstant,
    int verificationAttemptNb,
    VolaUser payer,
    VolaApplication application,
    PaymentStatus verificationStatus) {}
