package com.tsinjo.hei.model;

import java.util.UUID;

public record Help(
        UUID id,
        Beneficiary beneficiary,
        Payment payment,
        String description
) {}
