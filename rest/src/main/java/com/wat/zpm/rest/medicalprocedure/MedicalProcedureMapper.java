package com.wat.zpm.rest.medicalprocedure;

import com.wat.model.MedicalProcedure;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalProcedureMapper {
    MedicalProcedureResponse medicalProcedureToMedicalProcedureResponse(MedicalProcedure medicalProcedure);
}
