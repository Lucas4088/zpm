package com.wat.zpm.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ContactDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private AddressEntity address;
}
