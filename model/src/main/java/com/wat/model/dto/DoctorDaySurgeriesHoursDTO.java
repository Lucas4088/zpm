package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDaySurgeriesHoursDTO {
    private Integer doctorId;
    private Integer medicalCentreId;
    private LocalDate date;
}
