package com.tsinjo.hei.endpoint.DTO;

public record DonationViewrest(
        String type,              // "DON" ou "AIDE"
        String amount,            // ex: "12 500 Ar"
        String status,            // ex: "confirmé"
        String pspType,     // ex: "Orange Money"
        String date,              // formaté "05 août 2025"
        String donorName,
        String donorEmail,
        String description // null pour un don
) {
}
