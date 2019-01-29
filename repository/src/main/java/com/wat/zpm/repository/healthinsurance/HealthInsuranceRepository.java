package com.wat.zpm.repository.healthinsurance;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.HealthInsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface HealthInsuranceRepository extends JpaRepository<HealthInsuranceEntity, Integer> {
    Set<HealthInsuranceEntity> findAllByIdIn(Set<Integer> ids);
}
