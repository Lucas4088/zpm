package com.wat.model.role;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RolePatient {
    public final String name = "ROLE_PATIENT";

    public final Set<Permission> permissions = Stream.of(
            Permission.PREVIEW_HEALTH_INSURANCE,
            Permission.PREVIEW_VISIT,
            Permission.REQUEST_MANAGE_VISIT)
            .collect(Collectors.toSet());
}
