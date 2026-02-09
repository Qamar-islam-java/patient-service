package com.crescent.hms.patient;

import com.crescent.hms.patient.model.Patient;
import com.crescent.hms.patient.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public DataLoader(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Patient Data...");

        // Patient 1
        Patient p1 = new Patient();
        p1.setName("John Doe");
        p1.setNationalId("NAT-12345");
        p1.setDateOfBirth(LocalDate.of(1990, 5, 15));
        p1.setContactNumber("555-0101");

        // Patient 2
        Patient p2 = new Patient();
        p2.setName("Sarah Smith");
        p2.setNationalId("NAT-67890");
        p2.setDateOfBirth(LocalDate.of(1985, 8, 22));
        p2.setContactNumber("555-0102");

    //    patientRepository.save(p1);
      //  patientRepository.save(p2);

        System.out.println("Patient Data Loaded Successfully!");
    }
}