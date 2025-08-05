package com.tsinjo.hei.repository.jpa.mapper;

import com.tsinjo.hei.model.Payment;
import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import org.springframework.stereotype.Component;

@Component
public class JPaymentMapper {
    public Payment toDomain(JPayment j) {
        return new Payment(
                j.getId(),
                j.getDate(),
                j.getAmount(),
                j.getStatus()
        );
    }

    public JPayment toEntity(Payment p) {
        return new JPayment(
                p.id(),
                p.date(),
                p.amount(),
                p.status()
        );
    }
}
