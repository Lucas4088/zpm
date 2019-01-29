package com.wat.zpm.rest.role;

import com.wat.model.Role;
import com.wat.model.dto.AddRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    RoleResponse roleToRoleResponse(Role role);

    AddRoleDTO addRoleResqustToRole(AddRoleRequest addRoleRequest);
}
