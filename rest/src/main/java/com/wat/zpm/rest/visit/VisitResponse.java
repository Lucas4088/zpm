package com.wat.zpm.rest.visit;

import com.wat.model.Equipment;
import com.wat.model.Patient;
import com.wat.model.VisitState;
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
public class VisitResponse {
    private Integer id;
    private LocalDate dayOfTheVisit;
    private LocalTime startOfTheVisit;
    private LocalTime endOfTheVisit;
    private LocalDateTime dateOfCreation;
    private Integer medicalCentreId;
    private Set<Equipment> equipment;
    private Patient patient;
    private Integer doctorId;
    private VisitState visitState;
    private String stateNote;
    private Integer newDoctorId;

    private LocalDate newDayOfTheVisit;
    private LocalTime newStartOfTheVisit;

}
