package com.example.servicenowbackend.repositories;

import com.example.servicenowbackend.domain.models.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
