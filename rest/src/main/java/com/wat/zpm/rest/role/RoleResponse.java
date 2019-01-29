package com.wat.zpm.rest.role;

import com.wat.model.Authority;
import com.wat.zpm.rest.authority.AuthorityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private int id;
    private String name;
    private Set<AuthorityResponse> authorities;
}
