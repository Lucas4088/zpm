package com.wat.zpm.rest.visit;

import com.wat.model.Visit;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.model.exception.OperationForbiddenException;
import com.wat.zpm.service.VisitService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(VisitController.ENDPOINT)
public class VisitController {
    public static final String ENDPOINT = "/visit";

    private final VisitService visitService;
    private final VisitMapper visitMapper;

    public VisitController(VisitService visitService, VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @RequestMapping
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public Set<PatientVisitResponse> list() {
        return visitService.list()
                .stream()
                .map(visitMapper::visitToVisitPatientVisitResponse)
                .collect(Collectors.toSet());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MANAGE_VISIT')")
    public PatientVisitResponse add(@RequestBody AddVisitRequest addVisitRequest) throws ElementNotFoundException, OperationForbiddenException {
        return visitMapper.visitToVisitPatientVisitResponse(
                visitService.save(
                        visitMapper.addVisitRequestToAddVisitDTO(addVisitRequest)
                )
        );
    }

    @GetMapping(value = "/{visitId}")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public VisitResponse findById(@PathVariable Integer visitId) throws ElementNotFoundException {
        return visitMapper.visitToVisitResponse(
                visitService.findById(visitId)
        );
    }

    @GetMapping(value = "/day/{medicalCentreId}/{doctorId}/{date}")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public List<LocalTime> getVisitsForDateAndMedicalCentre(@PathVariable Integer medicalCentreId,
                                                            @PathVariable Integer doctorId,
                                                            @PathVariable
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws ElementNotFoundException {
        return visitService.getVisitsForDateAndMedicalCentre(medicalCentreId, doctorId, date);
    }

    @GetMapping(value = "/patient/{patientId}")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public Set<PatientVisitResponse> getPatientVisits(@PathVariable Integer patientId) throws ElementNotFoundException {
        return visitService.getPatientVisits(patientId)
                .stream()
                .map(visitMapper::patientVisitDTOToPatientVisitResponse)
                .collect(Collectors.toSet());
    }

    @PutMapping(value = "/request-cancel/{visitId}")
    @PreAuthorize("hasAuthority('REQUEST_MANAGE_VISIT')")
    public VisitResponse requestCancelVisit(@PathVariable Integer visitId,
                                            @RequestBody RequestCancelVisitRequest requestCancelVisitRequest) throws ElementNotFoundException, OperationForbiddenException {
        return visitMapper.visitToVisitResponse(
                visitService.requestCancelVisit(visitId,
                        visitMapper.cancelVisitRequestToRequestCancelVisitDTO(requestCancelVisitRequest))
        );
    }

    @PutMapping(value = "/request-reschedule-visit")
    @PreAuthorize("hasAuthority('REQUEST_MANAGE_VISIT')")
    public VisitResponse requestRescheduleVisit(@RequestBody RequestRescheduleVisitRequest requestRescheduleVisitRequest)
            throws ElementNotFoundException, OperationForbiddenException {
        return visitMapper.visitToVisitResponse(
                visitService.requestRescheduleVisit(visitMapper.requestRescheduleVisitRequestToRequestRescheduleVisitDTO(
                        requestRescheduleVisitRequest
                ))
        );
    }

    @GetMapping(value = "/process/{medicalCentreId}")
    @PreAuthorize("hasAuthority('MANAGE_VISIT')")
    public Set<VisitResponse> getAllToProcess(@PathVariable Integer medicalCentreId) {
        return visitService.getAllToProcess(medicalCentreId)
                .stream()
                .map(visitMapper::visitToVisitResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/list/{medicalCentreId}")
    @PreAuthorize("hasAuthority('PREVIEW_VISIT')")
    public Set<VisitResponse> getAllByMedicalCentre(@PathVariable Integer medicalCentreId) {
        return visitService.getAllByMedicalCentre(medicalCentreId)
                .stream()
                .map(visitMapper::visitToVisitResponse)
                .collect(Collectors.toSet());
    }


    @PutMapping(value = "/process")
    @PreAuthorize("hasAuthority('MANAGE_VISIT')")
    public Visit processVisit(@RequestBody ProcessVisitRequest processVisitRequest) throws ElementNotFoundException, OperationForbiddenException {
        return visitService.process(
                visitMapper.processVisitRequestToProcessVisitDTO(processVisitRequest)
        );
    }
}

