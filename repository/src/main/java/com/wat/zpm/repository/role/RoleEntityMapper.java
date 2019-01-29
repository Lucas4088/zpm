package com.wat.zpm.repository.role;

import com.wat.model.Role;
import com.wat.zpm.repository.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {
    Role roleEntityToRole(RoleEntity roleEntity);

    RoleEntity roleToRoleEntity(Role role);
}
