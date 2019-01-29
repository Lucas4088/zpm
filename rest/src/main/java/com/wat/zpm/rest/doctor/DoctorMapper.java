package com.wat.zpm.rest.doctor;

import com.wat.model.Doctor;
import com.wat.model.dto.AddSurgeryDTO;
import com.wat.model.dto.DeleteDoctorSurgeryDTO;
import com.wat.model.dto.DoctorDaySurgeriesHoursDTO;
import com.wat.zpm.rest.surgery.AddSurgeryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {
    DoctorResponse doctorToDoctorResponse(Doctor doctor);

    AddSurgeryDTO addSurgeryRequestToAddSurgeryDTO(AddSurgeryRequest addSurgeryRequest);

    DeleteDoctorSurgeryDTO deleteDoctorSurgeryRequestToDeleteDoctorSuegeryDTO(DeleteDoctorSurgeryRequest deleteDoctorSurgeryRequest);

    DoctorDaySurgeriesHoursDTO doctorDaySurgeriesHoursRequestToDoctorDaySurgeriesHoursDTO(DoctorDaySurgeriesHoursRequest doctorDaySurgeriesHoursRequest);
}
