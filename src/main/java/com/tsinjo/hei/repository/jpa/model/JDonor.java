package com.tsinjo.hei.repository.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@ToString
@EqualsAndHashCode
@Entity@Table(name = "donor")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class JDonor {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

}
