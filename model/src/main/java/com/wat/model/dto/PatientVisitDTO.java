package com.wat.model.dto;

import com.wat.model.*;
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
public class PatientVisitDTO {
    private int id;
    private LocalDate dayOfTheVisit;
    private MedicalCentre medicalCentre;
    private Patient patient;
    private Doctor doctor;
    private LocalTime startOfTheVisit;
    private LocalTime endOfTheVisit;
    private LocalDateTime dateOfCreation;
    private Set<Equipment> equipment;
    private VisitState visitState;
    private String stateNote;
}
