package com.wat.zpm.repository.healthservice;

import com.wat.model.Doctor;
import com.wat.model.HealthService;

import java.util.Set;

public interface HealthServiceRepositoryService {
    Set<HealthService> list();

    HealthService findById(int id);

    Set<HealthService> findByIds(Set<Integer> ids);

    HealthService update(HealthService healthService);

    HealthService save(HealthService healthService);
}
