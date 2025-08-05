package com.tsinjo.hei.repository.jpa;


import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.repository.jpa.model.JDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JDonationRepository extends JpaRepository<JDonation, UUID> {
    @Query("""
        SELECT d FROM JDonation d
        JOIN FETCH d.donor
        JOIN FETCH d.payment p
        WHERE p.status = :status
        """)
    List<JDonation> findAllByPaymentStatus(PaymentStatus status);
}
