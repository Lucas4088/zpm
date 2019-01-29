package com.wat.zpm.repository.specialization;

import com.wat.zpm.repository.ReceptionistEntity;
import com.wat.zpm.repository.SpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface SpecializationRepository extends JpaRepository<SpecializationEntity, Integer> {
    //Set<DoctorEntity> findAllByIdIn(Set<Integer> ids);
}
