package com.wat.zpm.repository.healthservice;

import com.wat.model.Doctor;
import com.wat.model.HealthService;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.HealthServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HealthServiceEntityMapper {
    HealthService healthServiceEntityToHealthService(HealthServiceEntity healthServiceEntity);

    HealthServiceEntity healthServiceToHealthServiceEntity(HealthService healthService);
}
