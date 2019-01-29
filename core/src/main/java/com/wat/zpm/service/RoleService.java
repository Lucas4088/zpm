package com.wat.zpm.service;

import com.wat.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> list();

    Role findById(int id);
}
