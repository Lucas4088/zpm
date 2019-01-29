package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
    private int id;
    private String name;
    private Set<MedicalProcedure> medicalProcedures;
}
