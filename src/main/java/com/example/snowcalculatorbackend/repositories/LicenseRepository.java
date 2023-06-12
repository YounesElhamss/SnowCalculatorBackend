package com.example.snowcalculatorbackend.repositories;

import com.example.snowcalculatorbackend.domain.models.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
}

