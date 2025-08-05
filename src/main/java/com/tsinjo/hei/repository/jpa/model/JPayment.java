package com.tsinjo.hei.repository.jpa.model;


import com.tsinjo.hei.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "\"payment\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JPayment {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Double amount;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;
}
