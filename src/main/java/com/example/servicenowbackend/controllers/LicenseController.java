
package com.example.programmeringseksamen.controllers;

import com.example.programmeringseksamen.domain.models.License;
import com.example.programmeringseksamen.domain.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LicenseController {

    private final LicenseService licenseService;

    @Autowired //dependency injection, så man ikke behøver at oprette et objekt
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @PostMapping("/createlicense")
    public ResponseEntity<License> createLicense(@RequestBody License license) {
        System.out.println(license.getLicenseName());
        licenseService.createLicense(license);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getlicenses")
    public ResponseEntity<List<License>> getLicenses() {

        List<License> controllerList = licenseService.getLicenses();
        return new ResponseEntity<>(controllerList, HttpStatus.OK);
    }

    //ReadById
    @GetMapping("/getlicense/{id}")
    public License getLicenseById(@PathVariable Long id) {
        Optional<License> read = licenseService.readLicenseById(id);
        return read.orElse(null);
    }

    @PutMapping("updatelicense/{id}")
    public ResponseEntity<License> updateLicenseById(@PathVariable Long id, @RequestBody License license) {
        license.setId(id);
        return new ResponseEntity<>(licenseService.updateLicenseById(license), HttpStatus.OK);
    }

    @DeleteMapping("deletelicense/{id}")
    public ResponseEntity<License> deleteLicenseById(@PathVariable Long id) {
        licenseService.deleteLicenseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

