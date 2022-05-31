package com.example.programmeringseksamen.repositories;

import com.example.programmeringseksamen.domain.models.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldRepository extends JpaRepository<Hold, Long> {
}
