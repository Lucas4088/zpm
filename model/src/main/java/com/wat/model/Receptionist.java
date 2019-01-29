package com.wat.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Receptionist extends User {
    private String description;

    public Receptionist(int id, String username, String password, String firstName, String lastName, String pesel, Address address, ContactDetails contactDetails, Gender gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstName, String mothersFirstName, int numberOfChildren, boolean underage, Set<Role> roles, String description) {
        super(id, username, password, firstName, lastName, pesel, address, contactDetails, gender, IDNumber, dateOfBirth, placeOfBirth, dateOfDeath, fathersFirstName, mothersFirstName, numberOfChildren, underage, roles);
        this.description = description;
    }
}
