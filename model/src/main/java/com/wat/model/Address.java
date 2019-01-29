package com.wat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer id;
    private Integer flatNumber;
    private Integer houseNumber;
    private String postalCode;
    private String locality;
    private String voivodeship;
    private String country;
}
