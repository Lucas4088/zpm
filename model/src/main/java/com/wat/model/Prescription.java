package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private Patient patient;
    private int number;
    private LocalDateTime dateOfIssue;
    private LocalDateTime dueDate;
    private List<Medicine> medicines;
}
