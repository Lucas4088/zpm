package com.wat.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateAddressDTO {
    private Integer flatNumber;
    private Integer houseNumber;
    private String postalCode;
    private String locality;
    private String country;
}
