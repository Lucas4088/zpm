package com.wat.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String pesel;
    private ContactDetails contactDetails;
    private Gender gender;
    private String email;
    private String IDNumber;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    private String fathersFirstName;
    private String mothersFirstName;
    private int numberOfChildren;
    private boolean underage;
    private Set<Role> roles;

    public User(int id, String username, String password, String firstName, String lastName, String pesel, Address address, ContactDetails contactDetails, Gender gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstName, String mothersFirstName, int numberOfChildren, boolean underage, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.contactDetails = contactDetails;
        this.gender = gender;
        this.IDNumber = IDNumber;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.fathersFirstName = fathersFirstName;
        this.mothersFirstName = mothersFirstName;
        this.numberOfChildren = numberOfChildren;
        this.underage = underage;
        this.roles = roles;
    }
}
