package com.wat.zpm;

import com.wat.model.Role;
import com.wat.zpm.repository.role.RoleRepositoryService;
import com.wat.zpm.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepositoryService roleRepositoryService;

    public RoleServiceImpl(RoleRepositoryService roleRepositoryService) {
        this.roleRepositoryService = roleRepositoryService;
    }

    @Override
    public Set<Role> list() {
        return roleRepositoryService.list();
    }

    @Override
    public Role findById(int id) {
        return roleRepositoryService.findById(id);
    }
}
