package com.tsinjo.hei.repository.jpa.mapper;

import com.tsinjo.hei.model.Donation;
import com.tsinjo.hei.repository.jpa.JDonorRepository;
import com.tsinjo.hei.repository.jpa.JPaymentRepository;
import com.tsinjo.hei.repository.jpa.model.JDonation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JDonationMapper {
  private final JDonorMapper donorMapper;
  private final JPaymentMapper paymentMapper;
  private final JDonorRepository donorRepo;
  private final JPaymentRepository paymentRepo;

  public Donation toDomain(JDonation j) {
    return new Donation(
        j.getId(), donorMapper.toDomain(j.getDonor()), paymentMapper.toDomain(j.getPayment()));
  }
}
