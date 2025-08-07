package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@ToString
@Table(name="beneficiary")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class JBeneficiary {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;
}
