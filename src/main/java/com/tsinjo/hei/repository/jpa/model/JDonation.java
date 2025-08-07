package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@ToString
@EqualsAndHashCode
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
