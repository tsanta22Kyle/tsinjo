package com.tsinjo.hei.repository.jpa.mapper;

import com.tsinjo.hei.model.Beneficiary;
import com.tsinjo.hei.repository.jpa.model.JBeneficiary;
import org.springframework.stereotype.Component;

@Component
public class JBeneficiaryMapper {
    public Beneficiary toDomain(JBeneficiary j) {
        return new Beneficiary(j.getId(), j.getFullName(), j.getEmail());
    }


}
