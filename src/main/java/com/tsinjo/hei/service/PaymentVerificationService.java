package com.tsinjo.hei.service;

import com.tsinjo.hei.model.Donation;
import com.tsinjo.hei.model.Payment;
import com.tsinjo.hei.model.PaymentStatus;
import com.tsinjo.hei.repository.jpa.JDonationRepository;
import com.tsinjo.hei.repository.jpa.JPaymentRepository;
import com.tsinjo.hei.repository.jpa.model.JDonation;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import com.tsinjo.hei.service.DTO.VolaPayment;
import com.tsinjo.hei.service.external.VolaClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentVerificationService {

    private final JDonationRepository donationRepository;
    private final VolaClient volaClient;

    @Scheduled(fixedDelay = 15000)
    public CompletableFuture<Void> checkAllPendingPayments() {
        log.info("🕒 Checking all pending payments...");

        List<JDonation> pendingDonations = donationRepository.findAllByPaymentStatus(PaymentStatus.VERIFYING);

        for (JDonation pendingDonation : pendingDonations) {
            var payment = pendingDonation.getPayment();
            var payer = pendingDonation.getDonor();

            VolaPayment volaResponse = volaClient.getPayment(
                    payer.getEmail(),
                    payment.getPspPaymentId(),
                    payment.getPspType().name()
            );

            if (volaResponse == null) continue;

            // Mise à jour du status si terminé
            var newStatus = volaResponse.verificationStatus();
            if (newStatus == PaymentStatus.SUCCEEDED || newStatus == PaymentStatus.FAILED) {
                log.info("✔️ Payment {} status updated to {}", payment.getId(), newStatus);
                payment.setStatus(newStatus);
                payment.setLastPspVerificationInstant(volaResponse.lastPspVerificationInstant());
                donationRepository.save(pendingDonation); // Cascade si bien configuré
            } else {
                log.info("🔄 Payment {} still verifying", payment.getId());
            }
        }

        return CompletableFuture.completedFuture(null);
    }

}
