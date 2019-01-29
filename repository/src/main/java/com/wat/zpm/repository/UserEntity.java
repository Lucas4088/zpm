package com.wat.zpm.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "User")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "TYPE")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String pesel;
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private ContactDetailsEntity contactDetails;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles;
    @Enumerated(value = EnumType.STRING)
    private GenderEntity gender;
    private String IDNumber;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    private String fathersFirstName;
    private String mothersFirstName;
    private int numberOfChildren;
    private boolean underage;
    private String email;

    public UserEntity(String firstName, String lastName, String pesel, ContactDetailsEntity contactDetails, GenderEntity gender, String IDNumber, LocalDate dateOfBirth, String placeOfBirth, LocalDate dateOfDeath, String fathersFirstName, String mothersFirstName, int numberOfChildren, boolean underage, Set<RoleEntity> roles, String email) {
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
        this.email = email;
    }
}
