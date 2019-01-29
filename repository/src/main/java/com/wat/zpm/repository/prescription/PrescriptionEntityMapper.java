package com.wat.zpm.repository.prescription;

import com.wat.model.Doctor;
import com.wat.model.Prescription;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.PrescriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrescriptionEntityMapper {
    Prescription prescriptionEntityToPrescription(PrescriptionEntity prescriptionEntity);

    PrescriptionEntity prescriptionToPrescriptionEntity(Prescription prescription);
}
