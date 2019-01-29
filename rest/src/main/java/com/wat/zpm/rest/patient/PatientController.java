package com.wat.zpm.rest.patient;

import com.wat.zpm.rest.schedule.ScheduleMapper;
import com.wat.zpm.rest.schedule.ScheduleResponse;
import com.wat.zpm.rest.schedule.ScheduleVisitRequest;
import com.wat.zpm.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(PatientController.ENDPOINT)
public class PatientController {
    static final String ENDPOINT = "/patient";

    private final PatientMapper patientMapper;
    private final PatientService patientService;
    private final ScheduleMapper scheduleMapper;

    public PatientController(PatientMapper patientMapper, PatientService patientService, ScheduleMapper scheduleMapper) {
        this.patientMapper = patientMapper;
        this.patientService = patientService;
        this.scheduleMapper = scheduleMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PREVIEW_PATIENT_LIST')")
    public Set<PatientResponse> list() {
        return patientService.list()
                .stream()
                .map(patientMapper::patientToPatientResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('PREVIEW_PATIENT')")
    public PatientResponse getById(@PathVariable int id) {
        return patientMapper.patientToPatientResponse(patientService.findById(id));
    }

    @PostMapping(value = "/schedule-visit")
    @PreAuthorize("hasAuthority('MANAGE_VISIT')")
    public ScheduleResponse scheduleVisit(@RequestBody ScheduleVisitRequest scheduleVisitRequest) {
        return null;
    }
}
