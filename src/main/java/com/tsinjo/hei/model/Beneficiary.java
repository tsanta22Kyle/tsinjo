package com.tsinjo.hei.model;

import java.util.UUID;

public record Beneficiary(
        UUID id,
        String fullName,
        String email
) {}
