package com.wat.zpm.rest.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wat.model.Gender;
import com.wat.zpm.rest.contactdetails.AddContactDetailsRequest;
import com.wat.zpm.rest.contactdetails.UpdateContactDetailsRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull
    @Email(message = "Email musi być w formacie email@mail.com")
    private String email;

    private Set<Integer> rolesId;

    @PositiveOrZero
    private int numberOfChildren;
    UpdateContactDetailsRequest contactDetails;
}
