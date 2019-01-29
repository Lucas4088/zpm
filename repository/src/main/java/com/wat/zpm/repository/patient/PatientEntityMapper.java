package com.wat.zpm.repository.patient;

import com.wat.model.Doctor;
import com.wat.model.Patient;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientEntityMapper {
    Patient patientEntityToPatient(PatientEntity patientEntity);

    PatientEntity doctorToPatientEntity(Patient patient);
}
