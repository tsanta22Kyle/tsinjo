package com.tsinjo.hei.repository.jpa;


import com.tsinjo.hei.repository.jpa.model.JDonation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JDonationRepository extends JpaRepository<JDonation, UUID> {
}
