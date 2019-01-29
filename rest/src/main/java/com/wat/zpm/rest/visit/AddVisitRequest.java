package com.wat.zpm.rest.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddVisitRequest {

    @NotNull
    private LocalTime startOfTheVisit;
    @NotNull
    private LocalDate date;
    @NotNull
    private Integer medicalCentreId;
    @NotNull
    private Integer patientId;
    @NotNull
    private Integer doctorId;
    @NotNull
    private LocalDate dateOfTheVisit;
    @NotNull
    private Integer medicalProcedureId;
}
