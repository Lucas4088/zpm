package com.wat.zpm.rest.user;

import com.wat.model.Address;
import com.wat.model.ContactDetails;
import com.wat.model.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserSignUpRequest {
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String pesel;
    private Address address;
    private ContactDetails contactDetails;
    private Gender gender;
    private String IDNumber;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    private String fathersFirstname;
    private String mothersFirstname;
    private int numberOfChildren;
    private boolean underage;
}
