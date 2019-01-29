package com.wat.zpm.repository.surgery;

import com.wat.model.Doctor;
import com.wat.model.Surgery;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.SurgeryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SurgeryEntityMapper {
    Surgery surgeryEntityToSurgery(SurgeryEntity surgeryEntity);

    SurgeryEntity surgeryToSurgeryEntity(Surgery surgery);
}
