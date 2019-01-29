package com.wat.zpm.repository.visit;

import com.wat.model.Doctor;
import com.wat.model.Visit;
import com.wat.model.VisitState;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface VisitRepositoryService {
    Set<Visit> list();

    Visit findById(int id);

    Set<Visit> findByIds(Set<Integer> ids);

    Visit update(Visit visit);

    Visit save(Visit visit);

    Set<Visit> findByPatientId(Integer patientId);

    Set<Visit> getAllByMedicalCentre(Integer medicalCentreId);
}
