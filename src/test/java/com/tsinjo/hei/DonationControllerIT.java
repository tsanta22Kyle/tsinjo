package com.tsinjo.hei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.tsinjo.hei.conf.FacadeIT;
import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.model.PspType;
import com.tsinjo.hei.repository.jpa.JDonationRepository;
import com.tsinjo.hei.repository.jpa.JDonorRepository;
import com.tsinjo.hei.repository.jpa.JPaymentRepository;
import com.tsinjo.hei.repository.jpa.model.JDonation;
import com.tsinjo.hei.repository.jpa.model.JDonor;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DonationControllerIT extends FacadeIT {

  @Autowired JDonationRepository jDonationRepository;

  @Autowired JDonorRepository jDonorRepository;

  @Autowired JPaymentRepository jPaymentRepository;

  @Test
  public void readPersistedDonnations() {
    var JDonor = new JDonor();
    JDonor.setId(UUID.randomUUID());
    JDonor.setFullName("kyle");
    JDonor.setEmail("kyle@gmail.com");
    var JPayment = new JPayment();
    JPayment.setId("PAYMENT001");
    JPayment.setAmount(123.456);
    JPayment.setPspPaymentId("MP250804.0904.A01637");
    JPayment.setDate(LocalDateTime.now());
    JPayment.setStatus(PaymentStatus.VERIFYING);
    JPayment.setPspType(PspType.ORANGE_MONEY);
    var JDonation = new JDonation();
    JDonation.setId(UUID.randomUUID());
    JDonation.setDonor(JDonor);
    JDonation.setPayment(JPayment);

    var persistedDonor = jDonorRepository.save(JDonor);
    var persistedPayment = jPaymentRepository.save(JPayment);
    var persistedDonation = jDonationRepository.save(JDonation);

    assertNotNull(persistedDonor);
    assertNotNull(persistedPayment);
    assertNotNull(persistedDonation);

    assertEquals(JDonation, persistedDonation);
    assertEquals(JDonor, persistedDonor);
    assertEquals(JPayment, persistedPayment);
  }
}
