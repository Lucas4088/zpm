package com.wat.model.role;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleAdmin {
    public final String name = "ROLE_ADMIN";

    public final Set<Permission> permissions = Stream.of(Permission.MANAGE_VISIT,
            Permission.PREVIEW_HEALTH_INSURANCE,
            Permission.PREVIEW_VISIT,
            Permission.PREVIEW_DOCTORS,
            Permission.PREVIEW_TREATMENT,
            Permission.REQUEST_MANAGE_VISIT)
            .collect(Collectors.toSet());
}
