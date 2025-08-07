package com.tsinjo.hei.repository.jpa;

import com.tsinjo.hei.repository.jpa.model.JHelp;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JHelpRepository extends JpaRepository<JHelp, UUID> {}
