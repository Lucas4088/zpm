package com.wat.zpm.rest.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVisitRequest {
    private Integer patientId;
    private Integer doctorId;
    private Integer medicalCentreId;
    private LocalDate dateOfVisit;
    //TODO private godzina
}
