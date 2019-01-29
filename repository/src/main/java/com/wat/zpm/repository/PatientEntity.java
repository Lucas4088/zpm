package com.wat.zpm.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name="Patient")
@DiscriminatorValue(value = "PATIENT")
@Data
@NoArgsConstructor
public class PatientEntity extends UserEntity {
    private int number;

    @OneToOne
    private HealthInsuranceEntity healthInsurance;
    private String description;

    public PatientEntity(String firstName, String lastName, String pesel, ContactDetailsEntity contactDetails, GenderEntity gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstname, String mothersFirstname, int numberOfChildren, boolean underage, Set<RoleEntity> roles, int number, HealthInsuranceEntity healthInsurance, String description, String email) {
        super(firstName, lastName, pesel, contactDetails, gender, IDNumber, dateOfBirth, placeOfBirth, dateOfDeath, fathersFirstname, mothersFirstname, numberOfChildren, underage, roles, email);
        this.number = number;
        this.healthInsurance = healthInsurance;
        this.description = description;
    }
}
