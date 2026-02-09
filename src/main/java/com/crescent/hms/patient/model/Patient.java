package com.crescent.hms.patient.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The unique key for Receptionists
    @Column(unique = true, nullable = false)
    private String nationalId;

    private String name;
    private LocalDate dateOfBirth;
    private String contactNumber;

    // In a real app, store address, blood group, etc.
}