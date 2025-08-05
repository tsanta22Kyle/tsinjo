package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.repository.jpa.model.JDonor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JDonorRepository extends JpaRepository<JDonor, UUID> {
    Optional<JDonor> findByEmail(String email);
}