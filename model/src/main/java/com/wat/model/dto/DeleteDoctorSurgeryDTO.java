package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDoctorSurgeryDTO {
    Integer doctorId;
    Integer surgeryId;
    Integer medicalCentreId;
}
