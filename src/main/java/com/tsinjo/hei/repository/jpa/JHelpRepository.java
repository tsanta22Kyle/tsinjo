package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.repository.jpa.model.JHelp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JHelpRepository extends JpaRepository<JHelp, UUID> {
}
