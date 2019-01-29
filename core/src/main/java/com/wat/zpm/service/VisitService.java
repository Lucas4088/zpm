package com.wat.zpm.service;

import com.wat.model.Visit;
import com.wat.model.dto.*;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.model.exception.OperationForbiddenException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface VisitService {
    List<Visit> list();

    Visit findById(int id) throws ElementNotFoundException;

    Visit save(AddVisitDTO addVisitDTO) throws ElementNotFoundException, OperationForbiddenException;

    void delete(int id);

    List<LocalTime> getVisitsForDateAndMedicalCentre(Integer medicalCentreId,
                                                     Integer doctorId,
                                                     LocalDate date) throws ElementNotFoundException;

    Set<PatientVisitDTO> getPatientVisits(Integer patientId) throws ElementNotFoundException;

    Visit requestCancelVisit(Integer visitId, RequestCancelVisitDTO request) throws ElementNotFoundException, OperationForbiddenException;

    Visit requestRescheduleVisit(RequestRescheduleVisitDTO requestRescheduleVisitDTO) throws ElementNotFoundException, OperationForbiddenException;

    Set<Visit> getAllToProcess(Integer medicalCentreId);

    Set<Visit> getAllByMedicalCentre(Integer medicalCentreId);

    Visit process(ProcessVisitDTO processVisitDTO) throws ElementNotFoundException, OperationForbiddenException;
}
