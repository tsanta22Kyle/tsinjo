package com.tsinjo.hei.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsinjo.hei.model.PspType;
import java.time.Instant;

public record VolaPspPayment(
    PspType pspType,
    String id,
    double amount,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC") Instant creationInstant) {}
