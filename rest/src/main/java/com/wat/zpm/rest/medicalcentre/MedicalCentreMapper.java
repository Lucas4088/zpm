package com.wat.zpm.rest.medicalcentre;

import com.wat.model.MedicalCentre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalCentreMapper {
    MedicalCentreResponse medicalCentreToMedicalCentreResponse(MedicalCentre medicalCentre);
}
