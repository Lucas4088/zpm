package com.wat.zpm.repository.healthinsurance;

import com.wat.model.Doctor;
import com.wat.model.HealthInsurance;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.HealthInsuranceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HealthInsuranceEntityMapper {
    HealthInsurance healthInsuranceEntityEntityToHealthInsurance(HealthInsuranceEntity healthInsuranceEntity);

    HealthInsuranceEntity healthInsuranceToHealthInsuranceEntity(HealthInsurance healthInsurance);
}
