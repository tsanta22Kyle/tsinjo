package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPaymentRepository extends JpaRepository<JPayment, UUID> {
  List<JPayment> findByStatus(PaymentStatus status);
}
