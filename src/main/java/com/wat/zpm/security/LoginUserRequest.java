package com.wat.zpm.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserRequest {
    private String username;
    private String password;
}
