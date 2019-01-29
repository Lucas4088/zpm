package com.wat.zpm.repository.medicalprocedure;

import com.wat.model.MedicalProcedure;
import com.wat.zpm.repository.MedicalProcedureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalProcedureEntityMapper {
    MedicalProcedureEntity medicalProcedureToMedicalProcedureEntity(MedicalProcedure MedicalProcedure);

    MedicalProcedure medicalProcedureEntityToMedicalProcedure(MedicalProcedureEntity medicalProcedureEntity);
}
