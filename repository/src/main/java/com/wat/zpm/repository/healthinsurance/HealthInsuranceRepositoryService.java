package com.wat.zpm.repository.healthinsurance;

import com.wat.model.Doctor;
import com.wat.model.HealthInsurance;

import java.util.Set;

public interface HealthInsuranceRepositoryService {
    Set<HealthInsurance> list();

    HealthInsurance findById(int id);

    Set<HealthInsurance> findByIds(Set<Integer> ids);

    HealthInsurance update(HealthInsurance healthInsurance);

    HealthInsurance save(HealthInsurance healthInsurance);
}
