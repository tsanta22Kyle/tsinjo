package com.tsinjo.hei.endpoint.rest.controller;


import com.tsinjo.hei.endpoint.DTO.DonationRest;
import com.tsinjo.hei.endpoint.DTO.DonationViewrest;
import com.tsinjo.hei.model.Donation;
import com.tsinjo.hei.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DonationController {
    private final DonationService donationService;

    @PostMapping("donate")
    public Donation donate(@RequestBody DonationRest donation){
        return donationService.save(donation);
    }

    @GetMapping("donations")
    public List<DonationViewrest> getDonations(){
        return donationService.getAllDonationViews();
    }

}
