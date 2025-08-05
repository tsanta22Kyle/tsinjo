package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
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
