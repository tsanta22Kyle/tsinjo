package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "donation")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class JDonation {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(optional = false)
    private JDonor donor;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private JPayment payment;
}
