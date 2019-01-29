package com.wat.zpm.rest.authority;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityResponse {
    private int id;
    private String name;
}
