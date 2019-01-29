package com.wat.zpm;

import com.wat.model.Patient;
import com.wat.zpm.repository.patient.PatientRepositoryService;
import com.wat.zpm.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepositoryService patientRepositoryService;

    public PatientServiceImpl(PatientRepositoryService patientRepositoryService) {
        this.patientRepositoryService = patientRepositoryService;
    }

    @Override
    public Set<Patient> list() {
        return patientRepositoryService.list();
    }

    @Override
    public Patient findById(int id) {
        return patientRepositoryService.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
