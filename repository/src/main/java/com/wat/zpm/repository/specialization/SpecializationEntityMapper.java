package com.wat.zpm.repository.specialization;

import com.wat.model.Specialization;
import com.wat.zpm.repository.SpecializationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecializationEntityMapper {
    Specialization specializationEntityToSpecialization(SpecializationEntity specializationEntity);

    SpecializationEntity specializationToSpecializationEntity(Specialization specialization);
}
