package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRescheduleVisitDTO {
    Integer newDoctorId;
    Integer visitId;
    LocalDate newDay;
    LocalTime newTime;
    String note;
}
