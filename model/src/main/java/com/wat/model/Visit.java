package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
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
    private LocalDateTime newRequestedDate;
    private Integer newDoctorId;
    private LocalDate newDayOfTheVisit;
    private LocalTime newStartOfTheVisit;
    private String stateNote;
}
