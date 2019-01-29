package com.wat.zpm.rest.role;

import com.wat.zpm.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RoleController.ENDPOINT)
public class RoleController {
    public static final String ENDPOINT = "/role";

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('PREVIEW_ROLE')")
    public Set<RoleResponse> list() {
        return roleService.list()
                .stream()
                .map(roleMapper::roleToRoleResponse)
                .collect(Collectors.toSet());
    }
}
