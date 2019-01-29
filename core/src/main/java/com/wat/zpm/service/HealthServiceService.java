package com.wat.zpm.service;

import com.wat.model.HealthService;

import java.util.List;

public interface HealthServiceService {
    List<HealthService> list();

    HealthService findById(int id);

    HealthService save(HealthService healthService);

    void delete(int id);
}
