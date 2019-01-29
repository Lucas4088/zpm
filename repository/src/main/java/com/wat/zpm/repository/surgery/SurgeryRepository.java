package com.wat.zpm.repository.surgery;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.SurgeryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface SurgeryRepository extends JpaRepository<SurgeryEntity, Integer> {
    Set<SurgeryEntity> findAllByIdIn(Set<Integer> ids);


}
