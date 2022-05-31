package com.example.programmeringseksamen.controllers;

import com.example.programmeringseksamen.domain.models.Hold;
import com.example.programmeringseksamen.domain.services.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hold")
@CrossOrigin
public class HoldController {

    private final HoldService holdService;

    @Autowired //dependency injection, så man ikke behøver at oprette et objekt
    public HoldController(HoldService holdService) {
        this.holdService = holdService;
    }

    @PostMapping
    public ResponseEntity<Hold> create(@RequestBody Hold hold) {
        holdService.create(hold);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hold>> read() {
        List<Hold> holdList = holdService.read();
        return new ResponseEntity<>(holdList, HttpStatus.OK);
    }

    //ReadById
    @GetMapping("/{id}")
    public Hold readById(@PathVariable Long id) {
        Optional<Hold> read = holdService.readById(id); //Optional så
        return read.orElse(null);
        /*
        LONG VERSION:
         if (read.isPresent()) {
            return read.get(); -> del af jpa
        } else {
            return null;
        }
        */
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hold> update(@PathVariable Long id, @RequestBody Hold hold) {
        hold.setId(id);
        return new ResponseEntity<>(holdService.update(hold), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Hold> delete(@PathVariable Long id) {
        holdService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}