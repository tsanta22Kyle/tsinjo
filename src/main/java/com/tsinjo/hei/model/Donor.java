package com.tsinjo.hei.model;

import java.util.UUID;

public record Donor(
        UUID id,
        String fullName,
        String email
) {}