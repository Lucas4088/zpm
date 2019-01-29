package com.wat.zpm.rest.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDaySurgeriesHoursRequest {
    private Integer doctorId;
    private Integer MedicalCentreId;
    private LocalDate date;
}
