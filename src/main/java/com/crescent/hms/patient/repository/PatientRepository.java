package com.crescent.hms.patient.repository;

import com.crescent.hms.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByNationalId(String nationalId);
}