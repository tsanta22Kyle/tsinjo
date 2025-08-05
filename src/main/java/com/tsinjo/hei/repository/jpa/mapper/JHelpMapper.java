package com.tsinjo.hei.repository.jpa.mapper;

import com.tsinjo.hei.model.Help;
import com.tsinjo.hei.repository.jpa.JBeneficiaryRepository;
import com.tsinjo.hei.repository.jpa.JPaymentRepository;
import com.tsinjo.hei.repository.jpa.model.JBeneficiary;
import com.tsinjo.hei.repository.jpa.model.JHelp;
import com.tsinjo.hei.repository.jpa.model.JPayment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JHelpMapper {
    private final JBeneficiaryMapper beneficiaryMapper;
    private final JPaymentMapper paymentMapper;
    private final JBeneficiaryRepository beneficiaryRepo;
    private final JPaymentRepository paymentRepo;

    public Help toDomain(JHelp j) {
        return new Help(
                j.getId(),
                beneficiaryMapper.toDomain(j.getBeneficiary()),
                paymentMapper.toDomain(j.getPayment()),
                j.getDescription()
        );
    }


}