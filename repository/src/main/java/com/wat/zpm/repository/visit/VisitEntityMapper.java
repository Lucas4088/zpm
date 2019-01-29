package com.wat.zpm.repository.visit;

import com.wat.model.Doctor;
import com.wat.model.Visit;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.VisitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitEntityMapper {
    Visit visitEntityToVisit(VisitEntity visitEntity);

    VisitEntity visitToVisitEntity(Visit visit);
}
