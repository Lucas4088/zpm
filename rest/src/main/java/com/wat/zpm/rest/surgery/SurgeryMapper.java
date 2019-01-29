package com.wat.zpm.rest.surgery;

import com.wat.model.Surgery;
import com.wat.model.dto.AddSurgeryDTO;
import com.wat.zpm.repository.surgery.SurgeryRepositoryService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SurgeryMapper {
    AddSurgeryDTO addSurgeryRequestToAddSurgeryDTO(AddSurgeryRequest addSurgeryRequest);

    SurgeryResponse surgeryToSurgeryResponse(Surgery surgery);
}
