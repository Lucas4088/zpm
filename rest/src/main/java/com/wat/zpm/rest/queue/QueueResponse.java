package com.wat.zpm.rest.queue;

import com.wat.model.MedicalCentre;
import com.wat.zpm.rest.address.AddressResponse;
import com.wat.zpm.rest.doctor.DoctorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueResponse {
    private int numberOfPatients;
    private MedicalCentre medicalCentre;
    private LocalDate firstAvailableDate;
}
