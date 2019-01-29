package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVisitDTO {
    private LocalTime startOfTheVisit;

    private LocalDate dateOfTheVisit;

    private LocalDate dateOfCreation;

    private int medicalCentreId;

    private int patientId;

    private int doctorId;

    private int medicalProcedureId;
}
