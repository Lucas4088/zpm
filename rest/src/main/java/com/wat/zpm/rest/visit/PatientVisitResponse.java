package com.wat.zpm.rest.visit;

import com.wat.model.Equipment;
import com.wat.model.VisitState;
import com.wat.zpm.rest.doctor.DoctorResponse;
import com.wat.zpm.rest.medicalcentre.MedicalCentreResponse;
import com.wat.zpm.rest.patient.PatientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientVisitResponse {
    private int id;
    private LocalDate dayOfTheVisit;
    private MedicalCentreResponse medicalCentre;
    private PatientResponse patient;
    private DoctorResponse doctor;
    private LocalTime startOfTheVisit;
    private LocalTime endOfTheVisit;
    private LocalDateTime dateOfCreation;
    private Set<Equipment> equipment;
    private VisitState visitState;
    private String stateNote;
}
