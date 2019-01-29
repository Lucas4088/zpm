package com.wat.zpm.rest.medicalcentre;

import com.wat.model.Doctor;
import com.wat.model.MedicalProcedure;
import com.wat.zpm.repository.AddressEntity;
import com.wat.zpm.rest.address.AddressResponse;
import com.wat.zpm.rest.doctor.DoctorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCentreResponse {
    private int id;
    private String name;
    private AddressResponse address;
    private Set<DoctorResponse> doctors;
    private Set<MedicalProcedure> medicalProcedures;
}
