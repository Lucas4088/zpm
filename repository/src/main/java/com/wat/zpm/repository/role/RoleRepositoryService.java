package com.wat.zpm.repository.role;

import com.wat.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleRepositoryService {
    Set<Role> list();

    Role findById(int id);

    Set<Role> findByIds(Set<Integer> ids);

    Role update(Role role);
}
