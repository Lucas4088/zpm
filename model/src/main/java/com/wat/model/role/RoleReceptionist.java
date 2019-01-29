package com.wat.model.role;

import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class RoleReceptionist {
    public final String name = "ROLE_RECEPTIONIST";

    public final Set<Permission> permissions = Stream.of(Permission.MANAGE_VISIT,
            Permission.PREVIEW_HEALTH_INSURANCE,
            Permission.PREVIEW_VISIT)
            .collect(Collectors.toSet());
}
