package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "\"help\"")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class JHelp {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(optional = false)
    private JBeneficiary beneficiary;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private JPayment payment;

    @Column(nullable = false)
    private String description;

}
