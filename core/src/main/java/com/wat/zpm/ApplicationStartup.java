package com.wat.zpm;

import com.wat.model.DayVisits;
import com.wat.model.Doctor;
import com.wat.model.Surgery;
import com.wat.zpm.repository.dayvisits.DayVisitsRepositoryService;
import com.wat.zpm.service.DoctorService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ApplicationStartup {

    private final DoctorService doctorService;
    private final DayVisitsRepositoryService dayVisitsRepositoryService;
    public ApplicationStartup(DoctorService doctorService, DayVisitsRepositoryService dayVisitsRepositoryService) {
        this.doctorService = doctorService;
        this.dayVisitsRepositoryService = dayVisitsRepositoryService;
    }

    @EventListener
    public void handleApplicationReady(ApplicationReadyEvent event) {
        /*LocalDate date = LocalDate.now();
        LocalDate lastPossibleDate = LocalDate.ofYearDay(2019, 365);

        Set<Doctor> allDoctors = doctorService.list();

        Map<DayVisits, Doctor> doctorToDayVisits = new HashMap<>();

        for (Doctor doctor : allDoctors) {
            //Set<DayVisits> doctorDayVisits = doctor.getDayVisits();
            doctor.getSchedules().forEach(
                    schedule -> {
                        for (int i = 0; i < ChronoUnit.DAYS.between(LocalDate.now(), lastPossibleDate); i++) {
                            LocalDate currentDate = date.plusDays(i);
                            Surgery surgery = schedule.getSurgeries()
                                    .stream()
                                    .filter(surgery1 -> surgery1.getDayOfWeek().equals(currentDate.getDayOfWeek()))
                                    .findFirst()
                                    .orElse(null);

                            if (surgery != null) {
                                DayVisits dayVisits = new DayVisits(
                                        null,
                                        currentDate,
                                        new ArrayList<>(),
                                        schedule.getMedicalCentreId(),
                                        true,
                                        0,
                                        calculateTotalVisits(doctor, surgery)
                                );

                                doctorToDayVisits.put(dayVisits, doctor);
                            }

                        }

                    }
            );

        }

        doctorToDayVisits.forEach(
                (dayVisits, doctor) -> {
                    DayVisits dv = dayVisitsRepositoryService.save(dayVisits);
                    doctor.getDayVisits().add(dv);
                    doctorService.save(doctor);
                }
        );*/

    }

    private int calculateTotalVisits(Doctor doctor, Surgery surgery) {
        return (int) Duration.between(surgery.getStartingTime(), surgery.getFinishingTime()).toMinutes()
                / doctor.getLengthOfVisit();
    }
}
