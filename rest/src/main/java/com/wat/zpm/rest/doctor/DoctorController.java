package com.wat.zpm.rest.doctor;

import com.wat.model.dto.DoctorDaySurgeriesHoursDTO;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.rest.schedule.ScheduleMapper;
import com.wat.zpm.rest.schedule.ScheduleResponse;
import com.wat.zpm.rest.surgery.AddSurgeryRequest;
import com.wat.zpm.rest.surgery.SurgeryMapper;
import com.wat.zpm.rest.surgery.SurgeryResponse;
import com.wat.zpm.service.DoctorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(DoctorController.ENDPOINT)
public class DoctorController {
    static final String ENDPOINT = "/doctor";

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;
    private final SurgeryMapper surgeryMapper;
    private final ScheduleMapper scheduleMapper;

    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper, SurgeryMapper surgeryMapper, ScheduleMapper scheduleMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
        this.surgeryMapper = surgeryMapper;
        this.scheduleMapper = scheduleMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PREVIEW_DOCTOR')")
    public Set<DoctorResponse> list() {
        return doctorService.list()
                .stream()
                .map(doctorMapper::doctorToDoctorResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('PREVIEW_DOCTOR')")
    public DoctorResponse getById(@PathVariable int id) {
        return doctorMapper.doctorToDoctorResponse(
                doctorService.findById(id)
        );
    }

    @PostMapping(value = "/surgery")
    @PreAuthorize("hasAuthority('MANAGE_SCHEDULE')")
    public SurgeryResponse addSurgery(@RequestBody @Validated AddSurgeryRequest addSurgeryRequest) throws ElementNotFoundException {
        return surgeryMapper.surgeryToSurgeryResponse(doctorService.addSurgery(
                doctorMapper.addSurgeryRequestToAddSurgeryDTO(addSurgeryRequest)
        ));
    }

    @PutMapping(value = "/surgery")
    @PreAuthorize("hasAuthority('MANAGE_SCHEDULE')")
    public void deleteSchedule(@RequestBody DeleteDoctorSurgeryRequest deleteDoctorSurgeryRequest) throws ElementNotFoundException {
        doctorService.deleteSurgery(
                doctorMapper.deleteDoctorSurgeryRequestToDeleteDoctorSuegeryDTO(deleteDoctorSurgeryRequest)
        );
    }

    @GetMapping(value = "/schedule/{doctorId}")
    @PreAuthorize("hasAuthority('MANAGE_SCHEDULE')")
    public ScheduleResponse getSchedule(@PathVariable Integer doctorId) {
        return null/*scheduleMapper.scheduleToScheduleResponse(doctorService.findById(doctorId)
                .getSchedules())*/;
    }

    @GetMapping(value = "/minAvailableDate/{doctorId}/{medicalCentreId}")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public LocalDate getMinAvailableDate(@PathVariable Integer doctorId,
                                       @PathVariable Integer medicalCentreId) throws ElementNotFoundException {
        return doctorService.getMinAvailableDate(doctorId, medicalCentreId);
    }

    @GetMapping(value = "/available-visits/{doctorId}/{medicalCentreId}/date")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public List<String> getDaySurgeries(@PathVariable Integer doctorId,
                                        @PathVariable Integer medicalCentreId,
                                        @PathVariable LocalDate date
    ) throws ElementNotFoundException {
        return doctorService.getDayVisits(
                new DoctorDaySurgeriesHoursDTO(doctorId, medicalCentreId, date));
    }

    @GetMapping(value = "/schedule/{medicalCentreId}/{doctorId}")
    @PreAuthorize("hasAuthority('MANAGE_SCHEDULE')")
    public ScheduleResponse getScheduleForMedicalCentre(@PathVariable Integer medicalCentreId,
                                                        @PathVariable Integer doctorId) throws ElementNotFoundException {
        return scheduleMapper.scheduleToScheduleResponse(
                doctorService.getDoctorScheduleForMedicalCentre(doctorId, medicalCentreId)
        );
    }
}
