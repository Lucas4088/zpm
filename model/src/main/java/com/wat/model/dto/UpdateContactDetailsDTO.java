package com.wat.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateContactDetailsDTO {
    private String phoneNumber;
    private UpdateAddressDTO address;
}
