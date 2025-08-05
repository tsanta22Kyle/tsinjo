package com.tsinjo.hei.service;

import com.tsinjo.hei.endpoint.DTO.DonationRest;
import com.tsinjo.hei.endpoint.DTO.DonationViewrest;
import com.tsinjo.hei.endpoint.mapper.DonationViewMapper;
import com.tsinjo.hei.model.Donation;
import com.tsinjo.hei.model.Payment;
import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.repository.jpa.JDonationRepository;
import com.tsinjo.hei.repository.jpa.JDonorRepository;
import com.tsinjo.hei.repository.jpa.JHelpRepository;
import com.tsinjo.hei.repository.jpa.JPaymentRepository;
import com.tsinjo.hei.repository.jpa.mapper.JDonationMapper;
import com.tsinjo.hei.repository.jpa.mapper.JDonorMapper;
import com.tsinjo.hei.repository.jpa.mapper.JHelpMapper;
import com.tsinjo.hei.repository.jpa.mapper.JPaymentMapper;
import com.tsinjo.hei.repository.jpa.model.JDonation;
import com.tsinjo.hei.repository.jpa.model.JDonor;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class DonationService {

    private final JDonorRepository donorRepo;
    private final JPaymentRepository paymentRepo;
    private final JDonationRepository donationRepo;
    private final JDonorMapper donorMapper;
    private final JPaymentMapper paymentMapper;
    private final JDonationMapper donationMapper;
    private final PaymentVerificationService verificationService;

    private final JDonationRepository donationRepository;
    private final JHelpRepository helpRepository;
    private final JHelpMapper helpMapper;
    private final DonationViewMapper viewMapper;

    public List<DonationViewrest> getAllDonationViews() {
        var donations = donationRepository.findAll();
        var helps = helpRepository.findAll();

        return Stream.concat(
                        donations.stream().map(donationMapper::toDomain).map(viewMapper::fromDonation),
                        helps.stream().map(helpMapper::toDomain).map(viewMapper::fromHelp)
                ).sorted((d1, d2) -> d2.date().compareTo(d1.date())) // tri anti-chronologique
                .toList();
    }


    public Donation save(DonationRest req) {
        JDonor jDonor = donorRepo.findByEmail(req.email())
                .orElseGet(() -> donorRepo.save(
                        new JDonor(UUID.randomUUID(), req.fullName(), req.email())
                ));

        // 2. Créer le Payment
        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                req.reference(),
                req.pspType(),
                null,
                LocalDateTime.now(),
                req.amount(),
                PaymentStatus.VERIFYING
        );


        JPayment jPayment = paymentRepo.save(paymentMapper.toEntity(payment));

        log.info("🟩 payment {} created", jPayment.getId());

        // 3. Créer et sauvegarder la Donation
        JDonation jDonation = new JDonation(UUID.randomUUID(), jDonor, jPayment);
        jDonation = donationRepo.save(jDonation);

        return donationMapper.toDomain(jDonation);
    }



}
