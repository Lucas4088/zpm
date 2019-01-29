package com.wat.zpm.rest.visit;

import com.wat.model.Visit;
import com.wat.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitMapper {
    PatientVisitResponse visitToVisitPatientVisitResponse(Visit visit);

    AddVisitDTO addVisitRequestToAddVisitDTO(AddVisitRequest addVisitRequest);

    VisitResponse visitToVisitResponse(Visit visit);

    PatientVisitResponse patientVisitDTOToPatientVisitResponse(PatientVisitDTO patientVisitDTO);

    RequestRescheduleVisitDTO requestRescheduleVisitRequestToRequestRescheduleVisitDTO(RequestRescheduleVisitRequest requestRescheduleVisitRequest);

    RequestCancelVisitDTO cancelVisitRequestToRequestCancelVisitDTO(RequestCancelVisitRequest cancelVisitRequest);

    ProcessVisitDTO processVisitRequestToProcessVisitDTO(ProcessVisitRequest processVisitRequest);
}
