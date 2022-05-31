package com.example.programmeringseksamen.controllers;

import com.example.programmeringseksamen.domain.models.CykelRytter;
import com.example.programmeringseksamen.domain.services.CykelRytterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cykelrytter")
@CrossOrigin
public class CykelrytterController {

    private final CykelRytterService cykelRytterService;

    @Autowired //dependency injection, så man ikke behøver at oprette et objekt
    public CykelrytterController(CykelRytterService cykelRytterService) {
        this.cykelRytterService = cykelRytterService;
    }

    @PostMapping
    public ResponseEntity<CykelRytter> create(@RequestBody CykelRytter cykelRytter) {
        cykelRytterService.create(cykelRytter);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CykelRytter>> read() {
        List<CykelRytter> controllerList = cykelRytterService.read();
        return new ResponseEntity<>(controllerList, HttpStatus.OK);
    }

    //ReadById
    @GetMapping("/{id}")
    public CykelRytter readById(@PathVariable Long id) {
        Optional<CykelRytter> read = cykelRytterService.readById(id); //Optional så
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
    public ResponseEntity<CykelRytter> update(@PathVariable Long id, @RequestBody CykelRytter cykelRytter) {
        cykelRytter.setId(id);
        return new ResponseEntity<>(cykelRytterService.update(cykelRytter), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CykelRytter> delete(@PathVariable Long id) {
        cykelRytterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hold/{id}")
    public ResponseEntity<List<CykelRytter>> getCykelrytterByHoldId(@PathVariable Long id) {
        System.out.println(id);
        List<CykelRytter> cykelryttere = cykelRytterService.getCykelryttereByHoldId(id);
        System.out.println(cykelryttere.size());
        return new ResponseEntity<>(cykelryttere, HttpStatus.OK);
    }
}


