package com.wat.zpm.rest.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wat.model.Gender;
import com.wat.zpm.rest.contactdetails.AddContactDetailsRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    @NotNull
    @Size(max = 20, message = "Nazwa użytkownika nie może przekraczać {max} znaków")
    private String username;
    @NotNull
    @Size(max = 20, message = "Hasło nie może przekraczać {max} znaków")
    private String password;
    @NotNull
    @Size(max = 255, message = "Imię nie może przekraczać {max} znaków")
    private String firstName;
    @NotNull
    @Size(max = 255, message = "Nazwisko nie może przekraczać {max} znaków")
    private String lastName;
    @NotNull
    @Size(min = 11, max = 11, message = "Pesel musi mieć dokładnie {max} cyfr")
    @Pattern(regexp = "[0-9]{11}", message = "Pesel może zawierać tylko cyfry")
    private String pesel;
    @NotNull
    private AddContactDetailsRequest contactDetails;
    private Gender gender;
    @NotNull
    @Email(message = "Email musi być w formacie email@mail.com")
    private String email;
    private String IDNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Data musi byc datą w przeszłości")
    private LocalDate dateOfBirth;
    @NotNull
    @Size(max = 255, message = "Miejsce urodzenia nie może przekraczać {max} znaków")
    private String placeOfBirth;
    private LocalDate dateOfDeath;
    @NotNull
    @Size(max = 255, message = "Imię ojca nie może przekraczać {max} znaków")
    private String fathersFirstName;
    @NotNull
    @Size(max = 255, message = "Imię matki nie może przekraczać {max} znaków")
    private String mothersFirstName;
    //@PositiveOrZero
    @DecimalMin(value = "0")
    private int numberOfChildren;
}
