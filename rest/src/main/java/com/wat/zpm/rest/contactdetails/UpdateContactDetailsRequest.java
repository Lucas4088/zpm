package com.wat.zpm.rest.contactdetails;

import com.wat.zpm.rest.address.AddAddressRequest;
import com.wat.zpm.rest.address.UpdateAddressRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UpdateContactDetailsRequest {
    @Pattern(regexp = "(\\+[0-9]{2})?[0-9]{9}", message = "Numer telefonu może zawierać tylko cyfry i może być tylko " +
            "w formacie (+48)999999999")
    private String phoneNumber;
    private UpdateAddressRequest address;
}
