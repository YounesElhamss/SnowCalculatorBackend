package com.example.programmeringseksamen.domain.services;

import com.example.programmeringseksamen.domain.models.CykelRytter;
import com.example.programmeringseksamen.repositories.CykelRytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CykelRytterService {

    private final CykelRytterRepository cykelRytterRepository;

    @Autowired
    public CykelRytterService(CykelRytterRepository cykelRytterRepository) {
        this.cykelRytterRepository = cykelRytterRepository;
    }

    //post
    public void create(CykelRytter cykelRytter) {
        cykelRytterRepository.save(cykelRytter);
    }

    //get
    public List<CykelRytter> read() {
        return cykelRytterRepository.findAll();
    }

    //getById
    public Optional<CykelRytter> readById(Long id){
        return cykelRytterRepository.findById(id);
    }

    //put
    public CykelRytter update(CykelRytter cykelRytter) {
        return cykelRytterRepository.save(cykelRytter);
    }

    //delete
    public void delete(Long id) {
        cykelRytterRepository.deleteById(id);
    }

    public List<CykelRytter> getCykelryttereByHoldId(Long id) {
        return cykelRytterRepository.getCykelRyttereByHoldId(id);
    }
}
