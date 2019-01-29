package com.wat.zpm.repository.patient;

import com.wat.model.Doctor;
import com.wat.model.Patient;

import java.util.Set;

public interface PatientRepositoryService {
    Set<Patient> list();

    Patient findById(int id);

    Set<Patient> findByIds(Set<Integer> ids);

    Patient update(Patient patient);

    //TODO save
}
