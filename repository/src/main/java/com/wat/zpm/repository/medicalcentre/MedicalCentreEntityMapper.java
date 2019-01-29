package com.wat.zpm.repository.medicalcentre;

import com.wat.model.HealthInsurance;
import com.wat.model.MedicalCentre;
import com.wat.zpm.repository.HealthInsuranceEntity;
import com.wat.zpm.repository.MedicalCentreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalCentreEntityMapper {
    MedicalCentre medicalCentreEntityToMedicalCentre(MedicalCentreEntity medicalCentreEntity);

    MedicalCentreEntity medicalCentreToMedicalCentreEntity(MedicalCentre medicalCentre);
}
