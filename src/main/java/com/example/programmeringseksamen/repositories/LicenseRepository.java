package com.example.programmeringseksamen.repositories;

import com.example.programmeringseksamen.domain.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
