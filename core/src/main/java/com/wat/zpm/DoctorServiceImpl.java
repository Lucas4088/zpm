package com.wat.zpm;

import com.wat.model.*;
import com.wat.model.dto.AddSurgeryDTO;
import com.wat.model.dto.DeleteDoctorSurgeryDTO;
import com.wat.model.dto.DoctorDaySurgeriesHoursDTO;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.repository.doctor.DoctorRepositoryService;
import com.wat.zpm.repository.schedule.ScheduleRepositoryService;
import com.wat.zpm.repository.surgery.SurgeryRepositoryService;
import com.wat.zpm.service.DoctorService;
import com.wat.zpm.service.MedicalCentreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepositoryService doctorRepositoryService;
    private final SurgeryRepositoryService surgeryRepositoryService;
    private final MedicalCentreService medicalCentreService;
    private final ScheduleRepositoryService scheduleRepositoryService;

    public DoctorServiceImpl(DoctorRepositoryService doctorRepositoryService, SurgeryRepositoryService surgeryRepositoryService, MedicalCentreService medicalCentreService, ScheduleRepositoryService scheduleRepositoryService) {
        this.doctorRepositoryService = doctorRepositoryService;
        this.surgeryRepositoryService = surgeryRepositoryService;
        this.medicalCentreService = medicalCentreService;
        this.scheduleRepositoryService = scheduleRepositoryService;
    }

    @Override
    public Set<Doctor> list() {
        return doctorRepositoryService.list();
    }

    @Override
    public Doctor findById(int id) {
        return doctorRepositoryService.findById(id);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepositoryService.save(doctor);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    @Transactional
    public Surgery addSurgery(AddSurgeryDTO addSurgeryDTO) throws ElementNotFoundException {
        Doctor doctor;
        try {
            doctor = doctorRepositoryService.findById(addSurgeryDTO.getDoctorId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        Surgery surgery = surgeryRepositoryService.save(new Surgery(null, addSurgeryDTO.getDayOfWeek(), addSurgeryDTO.getTitle(),
                addSurgeryDTO.getStartsAt(), addSurgeryDTO.getEndsAt(),
                addSurgeryDTO.getColor()));


        Set<Schedule> schedules = doctor.getSchedules();
        Schedule schedule = null;

        if (!((doctor.getSchedules()).isEmpty())) {
            schedule = schedules.stream()
                    .filter(schedule1 -> schedule1.getMedicalCentreId()
                            .equals(addSurgeryDTO.getMedicalCentreId()))
                    .findFirst()
                    .orElse(null);

        }

        if (schedule == null) {
            MedicalCentre medicalCentre;
            try {
                medicalCentre = medicalCentreService.findById(addSurgeryDTO.getMedicalCentreId());
            } catch (EntityNotFoundException e) {
                throw new ElementNotFoundException(e.getMessage());
            }
            Schedule newSchedule = new Schedule(null, null, medicalCentre.getId());
            schedule = scheduleRepositoryService.save(newSchedule);

            schedule.setSurgeries(new HashSet<>());
            schedule.getSurgeries().add(surgery);

            doctor.getSchedules().add(schedule);
            doctorRepositoryService.save(doctor);

        } else {
            Schedule schedule1 = doctor.getSchedules().stream()
                    .filter(schedule2 -> schedule2.getMedicalCentreId()
                            .equals(addSurgeryDTO.getMedicalCentreId()))
                    .collect(Collectors.toList())
                    .get(0);
            schedule1.getSurgeries().add(surgery);
            scheduleRepositoryService.save(schedule);
        }

        return surgery;
    }

    @Override
    public void deleteSurgery(DeleteDoctorSurgeryDTO deleteDoctorSurgeryDTO) throws ElementNotFoundException {
        Doctor doctor;
        try {
            doctor = doctorRepositoryService.findById(deleteDoctorSurgeryDTO.getDoctorId());
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }
        Schedule schedule = doctor.getSchedules()
                .stream()
                .filter(schedule1 -> schedule1.getMedicalCentreId()
                        .equals(deleteDoctorSurgeryDTO.getMedicalCentreId()))
                .collect(Collectors.toList())
                .get(0);
        if (schedule == null) {
            throw new ElementNotFoundException("No schedules defined");
        }
        Set<Surgery> surgeries = schedule.getSurgeries();

        surgeries.removeIf(
                surgery -> surgery.getId().equals(deleteDoctorSurgeryDTO.getSurgeryId())
        );
        schedule.setSurgeries(surgeries);

        scheduleRepositoryService.save(schedule);
    }

    @Override
    public LocalDate getMinAvailableDate(Integer doctorId, Integer medicalCentreId) throws ElementNotFoundException {
        Doctor doctor;
        try {
            doctor = doctorRepositoryService.findById(doctorId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        //filter only visits for given medical centre
        Set<DayVisits> dayVisitsMedicalCentre = doctor.getDayVisits()
                .stream()
                .filter(dayVisits -> dayVisits.getMedicalCentreId().equals(medicalCentreId))
                .collect(Collectors.toSet());

        LocalDate localDate;
        if (dayVisitsMedicalCentre.isEmpty()) {
            return LocalDate.now();
        } else {
            localDate = dayVisitsMedicalCentre.stream()
                    .filter(DayVisits::getIsAvailable)
                    .filter(dayVisits -> dayVisits.getDate().isAfter(LocalDate.now().minusDays(1)))
                    .min(Comparator.comparing(dayVisits -> dayVisits.getDate().toEpochDay()))
                    .get()
                    .getDate();
        }
        return localDate;
    }

    @Override
    public List<String> getDayVisits(DoctorDaySurgeriesHoursDTO doctorDaySurgeriesHoursDTO)
            throws ElementNotFoundException {
        return null;
    }

    @Override
    public Schedule getDoctorScheduleForMedicalCentre(Integer doctorId, Integer medicalCentreId) throws ElementNotFoundException {
        Doctor doctor;
        MedicalCentre medicalCentre;

        try {
            doctor = doctorRepositoryService.findById(doctorId);
            medicalCentre = medicalCentreService.findById(medicalCentreId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        Schedule schedule = doctor.getSchedules().stream()
                .filter(schedule1 -> schedule1.getMedicalCentreId().equals(medicalCentreId))
                .findFirst()
                .orElse(null);

        return schedule;
    }

    @Override
    public Integer numberOfVisits(Integer medicalCentreId, Doctor doctor) throws ElementNotFoundException {
        Set<DayVisits> dayVisits = doctor.getDayVisits();

        try {
            MedicalCentre medicalCentre = medicalCentreService.findById(medicalCentreId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(e.getMessage());
        }

        Set<DayVisits> dayVisitsByMedicalCentre = dayVisits.stream()
                .filter(dayVisits1 -> dayVisits1.getMedicalCentreId().equals(medicalCentreId))
                .collect(Collectors.toSet());

        List<Visit> visits = dayVisitsByMedicalCentre.stream()
                .map(DayVisits::getVisits)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return visits.size();
    }

    private String mapToTimeString(LocalDateTime localDateTime) {
        return localDateTime.getHour() + ":" + localDateTime.getMinute();
    }

}
