package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Doctor extends User {
    private Set<Specialization> specializations;
    private String description;
    private Integer pwz;
    private Set<Schedule> schedules;
    //private Set<MedicalCentre> medicalCentres;
    private Integer lengthOfVisit;
    private Set<DayVisits> dayVisits;

    public Doctor(int id, String username, String password, String firstName, String lastName, String pesel, Address address, ContactDetails contactDetails, Gender gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstName, String mothersFirstName, int numberOfChildren, boolean underage, Set<Role> roles, Set<Specialization> specializations, String description, Integer pwz, Set<Schedule> schedules, Integer lengthOfVisit, Set<DayVisits> dayVisits) {
        super(id, username, password, firstName, lastName, pesel, address, contactDetails, gender, IDNumber, dateOfBirth, placeOfBirth, dateOfDeath, fathersFirstName, mothersFirstName, numberOfChildren, underage, roles);
        this.specializations = specializations;
        this.description = description;
        this.pwz = pwz;
        this.schedules = schedules;
        this.lengthOfVisit = lengthOfVisit;
        this.dayVisits = dayVisits;
    }
}
