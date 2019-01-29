package com.wat.zpm.service;

import com.wat.model.Patient;

import java.util.Set;

public interface PatientService {
    Set<Patient> list();

    Patient findById(int id);

    Patient save(Patient patient);

    void delete(int id);
}
