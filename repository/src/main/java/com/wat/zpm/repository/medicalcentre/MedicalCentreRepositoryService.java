package com.wat.zpm.repository.medicalcentre;

import com.wat.model.Doctor;
import com.wat.model.MedicalCentre;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

public interface MedicalCentreRepositoryService {
    Set<MedicalCentre> list();

    MedicalCentre findById(int id) throws EntityNotFoundException;

    Set<MedicalCentre> findByIds(Set<Integer> ids);

    MedicalCentre update(MedicalCentre medicalCentre);

    MedicalCentre save(MedicalCentre medicalCentre);

    void delete(int id);

    Set<MedicalCentre> findAllByLocality(String locality);

    Set<String> findAllMedicalCentreLocalities();

    Set<Doctor> findAllDoctorsByMedicalCentre(int id);

    Set<MedicalCentre> findAllByVoievodeship(Set<String> veoievodeships);
}
