package com.wat.zpm;

import com.wat.model.HealthInsurance;
import com.wat.zpm.repository.healthinsurance.HealthInsuranceRepositoryService;
import com.wat.zpm.service.HealthInsuranceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    private final HealthInsuranceRepositoryService healthInsuranceRepositoryService;

    public HealthInsuranceServiceImpl(HealthInsuranceRepositoryService healthInsuranceRepositoryService) {
        this.healthInsuranceRepositoryService = healthInsuranceRepositoryService;
    }

    @Override
    public List<HealthInsurance> list() {
        return null;
    }

    @Override
    public HealthInsurance findById(int id) {
        return null;
    }

    @Override
    public HealthInsurance save(HealthInsurance healthInsurance) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
