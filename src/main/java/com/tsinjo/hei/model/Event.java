package com.tsinjo.hei.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Event {
  private final Payment payment;
  private final User user;
  private final LocalDateTime creationDate;
}
