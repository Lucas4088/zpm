package com.wat.zpm.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = true)
    private Integer flatNumber;
    private Integer houseNumber;
    private String postalCode;
    private String locality;
    private String voievodeship;
    private String country;
}
