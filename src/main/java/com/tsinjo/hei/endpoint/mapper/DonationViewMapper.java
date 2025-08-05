package com.tsinjo.hei.endpoint.mapper;

import com.tsinjo.hei.endpoint.DTO.DonationViewrest;
import com.tsinjo.hei.model.*;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DonationViewMapper {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);

    public DonationViewrest fromDonation(Donation donation) {
        Payment payment = donation.payment();

        return new DonationViewrest(
                "DON",
                formatAmount(payment.amount()),
                formatStatus(payment.status()),
                payment.status().toString(),
                FORMATTER.format(donation.payment().date()),
                donation.donor().fullName(),
                donation.donor().email(),
                null // Pas de description pour les dons
        );
    }

    public DonationViewrest fromHelp(Help help) {
        Payment payment = help.payment();

        return new DonationViewrest(
                "AIDE",
                formatAmount(payment.amount()),
                formatStatus(payment.status()),
                payment.pspType().toString(),
                FORMATTER.format(help.payment().date()),
                help.beneficiary().fullName(),
                help.beneficiary().email(),
                help.description()
        );
    }

    private String formatAmount(double amount) {
        return String.format("%,.0f Ar", amount).replace(',', ' ');
    }

    private String formatStatus(PaymentStatus status) {
        return switch (status) {
            case VERIFYING -> "en vérification";
            case SUCCEEDED -> "confirmé";
            case FAILED -> "échec";
        };
    }


}
