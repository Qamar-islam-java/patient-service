package com.crescent.hms.patient.controller;

import com.crescent.hms.patient.model.Patient;
import com.crescent.hms.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // 1. Register New Patient
    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        if (patientRepository.findByNationalId(patient.getNationalId()).isPresent()) {
            return ResponseEntity.badRequest().body("Patient already registered");
        }
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    // 2. Search by National ID (Receptionist Workflow)
    @GetMapping("/search")
    public ResponseEntity<?> searchPatient(@RequestParam String nationalId) {
        return patientRepository.findByNationalId(nationalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}