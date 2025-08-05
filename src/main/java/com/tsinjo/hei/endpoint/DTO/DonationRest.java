package com.tsinjo.hei.endpoint.DTO;

import com.tsinjo.hei.model.PspType;

public record DonationRest (
        String fullName,
        String email,
        double amount,
        String reference,
        PspType pspType
){

}
