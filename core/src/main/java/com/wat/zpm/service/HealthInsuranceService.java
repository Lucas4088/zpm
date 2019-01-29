package com.wat.zpm.service;

import com.wat.model.HealthInsurance;

import java.util.List;

public interface HealthInsuranceService {
    List<HealthInsurance> list();

    HealthInsurance findById(int id);

    HealthInsurance save(HealthInsurance healthInsurance);

    void delete(int id);
}
