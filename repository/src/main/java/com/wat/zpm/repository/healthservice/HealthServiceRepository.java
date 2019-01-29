package com.wat.zpm.repository.healthservice;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.HealthServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface HealthServiceRepository extends JpaRepository<HealthServiceEntity, Integer> {
    Set<HealthServiceEntity> findAllByIdIn(Set<Integer> ids);
}
