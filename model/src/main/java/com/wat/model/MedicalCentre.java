package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCentre {
    private Integer id;
    private String name;
    private String NIP;
    private String REGON;
    private String bankAccount;
    private Schedule schedule;
    private Address address;
    private Set<HealthService> healthServices;
    private Set<Doctor> doctors;
    private Set<Patient> patients;
    private Set<Receptionist> receptionists;
    private String description;
    private Set<MedicalProcedure> medicalProcedures;
}
