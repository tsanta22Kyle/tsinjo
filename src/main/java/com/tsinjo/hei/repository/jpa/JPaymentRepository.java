package com.tsinjo.hei.repository.jpa;


import com.tsinjo.hei.repository.jpa.model.JPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JPaymentRepository extends JpaRepository<JPayment, UUID> {
}
