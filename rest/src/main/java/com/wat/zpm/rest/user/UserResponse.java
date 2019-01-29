package com.wat.zpm.rest.user;

import com.wat.model.ContactDetails;
import com.wat.model.Gender;
import com.wat.zpm.rest.role.RoleResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String pesel;
    //private Address address;
    private ContactDetails contactDetails;
    private Gender gender;
    private String IDNumber;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    private String fathersFirstName;
    private String mothersFirstName;
    private int numberOfChildren;
    private boolean underage;
    private Set<RoleResponse> roles;
    private String email;
}
