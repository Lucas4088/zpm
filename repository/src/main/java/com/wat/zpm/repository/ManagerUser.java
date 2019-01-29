package com.wat.zpm.repository;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "Manager")
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue(value = "MANAGER")
public class ManagerUser extends UserEntity {

    public ManagerUser(String firstName, String lastName, String pesel, ContactDetailsEntity contactDetails, GenderEntity gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstname, String mothersFirstname, int numberOfChildren, boolean underage, Set<RoleEntity> roles, String email) {
        super(firstName, lastName, pesel, contactDetails, gender, IDNumber, dateOfBirth, placeOfBirth, dateOfDeath, fathersFirstname, mothersFirstname, numberOfChildren, underage, roles, email);
    }
}
