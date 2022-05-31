package com.example.programmeringseksamen.repositories;

import com.example.programmeringseksamen.domain.models.CykelRytter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CykelRytterRepository extends JpaRepository<CykelRytter, Long> {
    @Query(value = "SELECT c" +
            " FROM CykelRytter c " +
            "WHERE c.hold.id = ?1")
    List<CykelRytter> getCykelRyttereByHoldId(Long id);
}
