package com.wat.zpm.rest.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    int id;
    private int flatNumber;
    private int houseNumber;
    private String postalCode;
    private String locality;
    private String voievodeship;
    private String country;
}
