package com.wat.zpm.repository.equipment;

import com.wat.zpm.repository.EquipmentEntity;
import com.wat.zpm.repository.HealthInsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer> {
    Set<EquipmentEntity> findAllByIdIn(Set<Integer> ids);
}
