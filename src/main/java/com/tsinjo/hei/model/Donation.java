package com.tsinjo.hei.model;

import java.util.UUID;

public record Donation(UUID id, Donor donor, Payment payment) {}
