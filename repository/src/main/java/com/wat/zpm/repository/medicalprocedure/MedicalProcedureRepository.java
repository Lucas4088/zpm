package com.wat.zpm.repository.medicalprocedure;

import com.wat.zpm.repository.HealthInsuranceEntity;
import com.wat.zpm.repository.MedicalProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface MedicalProcedureRepository extends JpaRepository<MedicalProcedureEntity, Integer> {
}
