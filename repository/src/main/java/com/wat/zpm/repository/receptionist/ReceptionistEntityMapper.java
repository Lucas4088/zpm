package com.wat.zpm.repository.receptionist;

import com.wat.model.Doctor;
import com.wat.model.Receptionist;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.ReceptionistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceptionistEntityMapper {
    Receptionist receptionistEntityToReceptionist(ReceptionistEntity receptionistEntity);

    ReceptionistEntity receptionistToReceptionistEntity(Receptionist receptionist);
}
