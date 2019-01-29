package com.wat.zpm.rest.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UpdateAddressRequest {
    @Positive
    private Integer flatNumber;
    @Positive
    private Integer houseNumber;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "kod pocztowy może zawierać tylko cyfry i być w formacie 00-000")
    private String postalCode;
    @Size(max = 225, message = "Miejscowość nie może przekraczać {max} znaków")
    private String locality;

    private String voievodeship;
    @Size(max = 225, message = "Pasńtwo nie może przekraczać {max} znaków")
    private String country;
}
