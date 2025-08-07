package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.repository.jpa.model.JBeneficiary;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JBeneficiaryRepository extends JpaRepository<JBeneficiary, UUID> {
  Optional<JBeneficiary> findByEmail(String email);
}
