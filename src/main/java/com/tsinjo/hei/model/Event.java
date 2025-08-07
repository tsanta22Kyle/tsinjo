package com.tsinjo.hei.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Event {
    private final Payment payment;
    private final User user;
    private final LocalDateTime creationDate;
}
