package com.tsinjo.hei.repository.jpa.model;


import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.model.PspType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JPayment {
    @Id
    private String id ;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "psp_type",nullable = false)
    private PspType pspType;

    @Column(name = "psp_payment_id",nullable = false)
    private String pspPaymentId;

    @Column(name = "last_psp_verification_instant")
    private Instant lastPspVerificationInstant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;
}
