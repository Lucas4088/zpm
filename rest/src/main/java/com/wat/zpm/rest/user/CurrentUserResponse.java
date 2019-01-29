package com.wat.zpm.rest.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CurrentUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private Set<String> roles;
    private Set<String> authorities;

}
