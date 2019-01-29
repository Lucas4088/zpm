package com.wat.zpm.rest.specialization;

import com.wat.model.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpecializationMapper {
    SpecializationResponse specializationToSpecializationResponse(Specialization specialization);
}
