package com.wat.zpm.rest.patient;

import com.wat.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {
    PatientResponse patientToPatientResponse(Patient patient);
}
