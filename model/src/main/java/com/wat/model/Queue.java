package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Queue {
    private int numberOfPatients;
    private MedicalCentre medicalCentre;
    private LocalDate firstAvailableDate;
}
