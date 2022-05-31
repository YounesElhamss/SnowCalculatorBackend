package com.example.programmeringseksamen.controllers;

import com.example.programmeringseksamen.domain.models.CykelRytter;
import com.example.programmeringseksamen.domain.models.Hold;
import com.example.programmeringseksamen.repositories.CykelRytterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CykelRytterControllerTest {

    @Autowired
    private CykelRytterRepository cykelRytterRepository;

    @Test
    void create() {
        Hold hold = new Hold();
        CykelRytter cykelRytter = new CykelRytter(1L,"Younes", 1L, hold); //1L betyder Long
        cykelRytterRepository.save(cykelRytter);

        assertEquals(cykelRytter.getName(), cykelRytterRepository.findById(1L).get().getName());
    }


}