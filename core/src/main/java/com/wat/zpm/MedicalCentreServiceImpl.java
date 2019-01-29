package com.wat.zpm;

import com.wat.model.*;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.repository.doctor.DoctorRepositoryService;
import com.wat.zpm.repository.medicalcentre.MedicalCentreRepositoryService;
import com.wat.zpm.repository.receptionist.ReceptionistRepositoryService;
import com.wat.zpm.service.MedicalCentreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicalCentreServiceImpl implements MedicalCentreService {
    private final MedicalCentreRepositoryService medicalCentreRepositoryService;
    private final DoctorRepositoryService doctorRepositoryService;
    private final ReceptionistRepositoryService receptionistRepositoryService;

    public MedicalCentreServiceImpl(MedicalCentreRepositoryService medicalCentreRepositoryService, DoctorRepositoryService doctorRepositoryService, ReceptionistRepositoryService receptionistRepositoryService) {
        this.medicalCentreRepositoryService = medicalCentreRepositoryService;
        this.doctorRepositoryService = doctorRepositoryService;
        this.receptionistRepositoryService = receptionistRepositoryService;
    }

    @Override
    public Set<MedicalCentre> list() {
        return medicalCentreRepositoryService.list();
    }

    @Override
    public MedicalCentre findById(int id) {
        return medicalCentreRepositoryService.findById(id);
    }

    @Override
    public MedicalCentre save(MedicalCentre medicalCentre) {
        return medicalCentreRepositoryService.save(medicalCentre);
    }

    @Override
    public void delete(int id) {
        medicalCentreRepositoryService.delete(id);
    }

    @Override
    public Set<MedicalCentre> findAllByLocality(String locality) {
        return medicalCentreRepositoryService.findAllByLocality(locality);
    }

    @Override
    public Set<String> findAllMedicalCentreLocalities() {
        return medicalCentreRepositoryService.findAllMedicalCentreLocalities();
    }

    @Override
    public Set<Doctor> findAllDoctorsByMedicalCentre(int id) {
        return medicalCentreRepositoryService.findAllDoctorsByMedicalCentre(id);
    }

    @Override
    public Set<MedicalCentre> findByDoctor(int id) throws ElementNotFoundException {
        Doctor doctor;
        try {
            doctor = doctorRepositoryService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        return medicalCentreRepositoryService.list()
                .stream()
                .filter(medicalCentre -> medicalCentre.getDoctors().contains(doctor))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<MedicalCentre> findByReceptionist(int id) throws ElementNotFoundException {
        Receptionist receptionist;
        try {
            receptionist = receptionistRepositoryService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        return medicalCentreRepositoryService.list()
                .stream()
                .filter(medicalCentre -> medicalCentre.getReceptionists().contains(receptionist))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> findAllPatientsByMedicalCentre(int id) throws ElementNotFoundException {
        MedicalCentre medicalCentre;

        try {
            medicalCentre = medicalCentreRepositoryService.findById(id);
        } catch (EntityExistsException e) {
            throw new ElementNotFoundException(e.getMessage());
        }


        return medicalCentre.getPatients();
    }

    @Override
    public Set<Equipment> getAllAvailableEquipmentForDay(int medicalCentreId, LocalDate date) throws ElementNotFoundException {
        MedicalCentre medicalCentre;

        try {
            medicalCentre = medicalCentreRepositoryService.findById(medicalCentreId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        Set<Equipment> totalEquipment = medicalCentre.getMedicalProcedures().stream()
        .map(MedicalProcedure::getEquipment)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        Set<Doctor> doctors = medicalCentre.getDoctors();

        List<DayVisits> dayVisits = doctors.stream()
                .map(Doctor::getDayVisits)
                .flatMap(Collection::stream)
                .filter(dayVisits1 -> dayVisits1.getMedicalCentreId().equals(medicalCentreId)&&
                        dayVisits1.getDate().equals(date))
                .collect(Collectors.toList());

        Set<Visit> visits = dayVisits.stream()
                .map(DayVisits::getVisits)
                .flatMap(Collection::stream)
                .filter(visit -> visit.getVisitState() != VisitState.DATE_CHANGED &&
                        visit.getVisitState() != VisitState.DELETED)
                .collect(Collectors.toSet());

        Set<Equipment> usedEquipment = new HashSet<>();

        visits.forEach(visit -> {
            usedEquipment.addAll(visit.getEquipment());
        });

        totalEquipment.removeAll(usedEquipment);

        return totalEquipment;
    }

}
