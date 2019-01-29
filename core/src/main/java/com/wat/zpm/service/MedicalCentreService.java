package com.wat.zpm.service;

import com.wat.model.Doctor;
import com.wat.model.Equipment;
import com.wat.model.MedicalCentre;
import com.wat.model.Patient;
import com.wat.model.exception.ElementNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface MedicalCentreService {
    Set<MedicalCentre> list();

    MedicalCentre findById(int id);

    MedicalCentre save(MedicalCentre medicalCentre);

    void delete(int id);

    Set<MedicalCentre> findAllByLocality(String locality);

    Set<String> findAllMedicalCentreLocalities();

    Set<Doctor> findAllDoctorsByMedicalCentre(int id);

    Set<MedicalCentre> findByDoctor(int id) throws ElementNotFoundException;

    Set<MedicalCentre> findByReceptionist(int id) throws ElementNotFoundException;

    Set<Patient> findAllPatientsByMedicalCentre(int id) throws ElementNotFoundException;

    Set<Equipment> getAllAvailableEquipmentForDay(int medicalCentreId, LocalDate date) throws ElementNotFoundException;
}
