package com.example.snowcalculatorbackend.domain.services;

import com.example.snowcalculatorbackend.domain.models.License;
import com.example.snowcalculatorbackend.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    @Autowired
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    //post
    public void createLicense(License license) {
        licenseRepository.save(license);
    }

    //get
    public List<License> getLicenses() {
        return licenseRepository.findAll();
    }

    //getById
    public Optional<License> readLicenseById(Long id){
        return licenseRepository.findById(id);
    }

    //put
    public License updateLicenseById(License license) {
        return licenseRepository.save(license);
    }

    //delete
    public void deleteLicenseById(Long id) {
        licenseRepository.deleteById(id);
    }

}
