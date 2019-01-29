package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    private int id;
    private String email;

    private Set<Integer> rolesId;

    private int numberOfChildren;

    private UpdateContactDetailsDTO contactDetails;
}
