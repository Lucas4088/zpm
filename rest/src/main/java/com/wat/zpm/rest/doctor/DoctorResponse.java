package com.wat.zpm.rest.doctor;

import com.wat.model.ContactDetails;
import com.wat.model.Gender;
import com.wat.zpm.rest.role.RoleResponse;
import com.wat.zpm.rest.schedule.ScheduleResponse;
import com.wat.zpm.rest.specialization.SpecializationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String pesel;
    //private Address address;
    private ScheduleResponse schedule;
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
    private int pwz;
    private Long lengthOfVisit;
    private Set<SpecializationResponse>  specializations;
}
