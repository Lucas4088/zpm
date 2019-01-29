package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueParametersDTO {
    Integer specializationId;
    Integer medicalCentreId;
    Set<String> voievodeship;
}
