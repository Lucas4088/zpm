package com.wat.zpm.repository.prescription;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Integer> {
    Set<PrescriptionEntity> findAllByIdIn(Set<Integer> ids);
}
