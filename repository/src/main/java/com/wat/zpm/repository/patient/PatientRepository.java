package com.wat.zpm.repository.patient;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    /*Set<PatientEntity> findAllByIdIn(Set<Integer> ids);*/
}
