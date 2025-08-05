package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.repository.jpa.model.JBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JBeneficiaryRepository extends JpaRepository<JBeneficiary, UUID> {
    Optional<JBeneficiary> findByEmail(String email);
}
