package com.wat.zpm.service;

import com.wat.model.*;
import com.wat.model.dto.AddSurgeryDTO;
import com.wat.model.dto.DeleteDoctorSurgeryDTO;
import com.wat.model.dto.DoctorDaySurgeriesHoursDTO;
import com.wat.model.exception.ElementNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface DoctorService {
    Set<Doctor> list();

    Doctor findById(int id);

    Doctor save(Doctor doctor);

    void delete(int id);

    Surgery addSurgery(AddSurgeryDTO addSurgeryDTO) throws ElementNotFoundException;

    void deleteSurgery(DeleteDoctorSurgeryDTO deleteDoctorSurgeryDTO) throws ElementNotFoundException;

    LocalDate getMinAvailableDate(Integer doctorId, Integer medicalCentreId) throws ElementNotFoundException;

    List<String> getDayVisits(DoctorDaySurgeriesHoursDTO doctorDaySurgeriesHoursDTO) throws  ElementNotFoundException;

    Integer numberOfVisits(Integer medicalCentreId, Doctor doctor) throws ElementNotFoundException;

    Schedule getDoctorScheduleForMedicalCentre(Integer doctorId, Integer medicalCentreId) throws ElementNotFoundException;
}
