package com.wat.zpm.repository.doctor;

import com.wat.model.Doctor;
import com.wat.model.Role;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorEntityMapper {
    Doctor doctorEntityToDoctor(DoctorEntity doctorEntity);

    DoctorEntity doctorToDoctorEntity(Doctor doctor);
}
