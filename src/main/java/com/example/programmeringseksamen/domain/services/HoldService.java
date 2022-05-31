package com.example.programmeringseksamen.domain.services;

import com.example.programmeringseksamen.domain.models.Hold;
import com.example.programmeringseksamen.repositories.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldService {

    private final HoldRepository holdRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository) {
        this.holdRepository = holdRepository;
    }

    //post
    public void create(Hold hold) {
        holdRepository.save(hold);
    }

    //get
    public List<Hold> read() {
        return holdRepository.findAll();
    }

    //getById
    public Optional<Hold> readById(Long id){
        return holdRepository.findById(id);
    }

    //put
    public Hold update(Hold hold) {
        return holdRepository.save(hold);
    }

    //delete
    public void delete(Long id) {
        holdRepository.deleteById(id);
    }






}
