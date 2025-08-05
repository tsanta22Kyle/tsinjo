package com.tsinjo.hei.repository.jpa.mapper;

import com.tsinjo.hei.model.Donor;
import com.tsinjo.hei.repository.jpa.model.JDonor;
import org.springframework.stereotype.Component;

@Component
public class JDonorMapper {
    public Donor toDomain(JDonor j) {
        return new Donor(j.getId(), j.getFullName(), j.getEmail());
    }


}
