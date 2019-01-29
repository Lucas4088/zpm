package com.wat.zpm.rest.medicalprocedure;

import com.wat.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalProcedureResponse {
    private Integer id;
    private String name;

    private Set<Equipment> equipment;
}
