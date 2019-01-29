package com.wat.zpm.rest.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRescheduleVisitRequest {
    private Integer newDoctorId;
    private Integer visitId;
    private LocalDate newDay;
    private LocalTime newTime;
    private String stateNote;
}
