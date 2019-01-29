package com.wat.zpm.repository.medicalprocedure;

import com.wat.model.HealthInsurance;
import com.wat.model.MedicalProcedure;

import java.util.Set;

public interface MedicalProcedureRepositoryService {
    Set<MedicalProcedure> list();

    MedicalProcedure findById(int id);

    Set<MedicalProcedure> findByIds(Set<Integer> ids);

    MedicalProcedure update(MedicalProcedure medicalProcedure);

    MedicalProcedure save(MedicalProcedure medicalProcedure);
}
