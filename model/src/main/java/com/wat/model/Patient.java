package com.wat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class Patient extends User {
    private int number;

    private HealthInsurance healthInsurance;
    private String description;

    public Patient(int id, String username, String password, String firstName, String lastName, String pesel, Address address, ContactDetails contactDetails, Gender gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstname, String mothersFirstname, int numberOfChildren, boolean underage, Set<Role> roles, int number, HealthInsurance healthInsurance, String description) {
        super(id, username, password, firstName, lastName, pesel, address, contactDetails, gender, IDNumber, dateOfBirth, placeOfBirth, dateOfDeath, fathersFirstname, mothersFirstname, numberOfChildren, underage, roles);
        this.number = number;
        this.healthInsurance = healthInsurance;
        this.description = description;
    }
}
