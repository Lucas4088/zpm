package com.wat.zpm.rest.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDoctorSurgeryRequest {
    @NotNull
    Integer doctorId;
    @NotNull
    Integer surgeryId;
    @NotNull
    Integer medicalCentreId;
}
