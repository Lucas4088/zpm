package com.wat.zpm.rest.medicalcentre;

import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.rest.doctor.DoctorMapper;
import com.wat.zpm.rest.doctor.DoctorResponse;
import com.wat.zpm.rest.patient.PatientMapper;
import com.wat.zpm.rest.patient.PatientResponse;
import com.wat.zpm.service.MedicalCentreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MedicalCentreController.ENDPOINT)
public class MedicalCentreController {
    static final String ENDPOINT = "/medical-centre";

    private final MedicalCentreService medicalCentreService;
    private final MedicalCentreMapper medicalCentreMapper;
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    public MedicalCentreController(MedicalCentreService medicalCentreService, MedicalCentreMapper medicalCentreMapper, DoctorMapper doctorMapper, PatientMapper patientMapper) {
        this.medicalCentreService = medicalCentreService;
        this.medicalCentreMapper = medicalCentreMapper;
        this.doctorMapper = doctorMapper;
        this.patientMapper = patientMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public Set<MedicalCentreResponse> list() {
        return medicalCentreService.list()
                .stream()
                .map(medicalCentreMapper::medicalCentreToMedicalCentreResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public MedicalCentreResponse findById(@PathVariable Integer id) {
        return medicalCentreMapper.medicalCentreToMedicalCentreResponse(
                medicalCentreService.findById(id)
        );
    }

    @GetMapping(value = "/by-locality/{locality}")
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public Set<MedicalCentreResponse> findAllByLocality(@PathVariable String locality) {
        return medicalCentreService.findAllByLocality(locality)
                .stream()
                .map(medicalCentreMapper::medicalCentreToMedicalCentreResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/localities")
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public Set<String> findAllMedicalCentreLocalities() {
        return medicalCentreService.findAllMedicalCentreLocalities();
    }

    @GetMapping(value = "/doctors/by-id/{medicalCentreId}")
    @PreAuthorize("hasAuthority('PREVIEW_DOCTOR')")
    public Set<DoctorResponse> findAllDoctors(@PathVariable int medicalCentreId) {
        return medicalCentreService.findAllDoctorsByMedicalCentre(medicalCentreId)
                .stream()
                .map(doctorMapper::doctorToDoctorResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/by-doctor/{doctorId}")
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public Set<MedicalCentreResponse> findByDoctor(@PathVariable Integer doctorId) throws ElementNotFoundException {
        return medicalCentreService.findByDoctor(doctorId)
                .stream()
                .map(medicalCentreMapper::medicalCentreToMedicalCentreResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/by-receptionist/{receptionistId}")
    @PreAuthorize("hasAuthority('PREVIEW_MEDICAL_CENTRE')")
    public Set<MedicalCentreResponse> findByReceptionist(@PathVariable Integer receptionistId)
            throws ElementNotFoundException {
        return medicalCentreService.findByReceptionist(receptionistId)
                .stream()
                .map(medicalCentreMapper::medicalCentreToMedicalCentreResponse)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/patients/list/{medicalCentreId}")
    @PreAuthorize("hasAuthority('PREVIEW_PATIENT')")
    public Set<PatientResponse> findAllPatientsByMedicalCentre(@PathVariable Integer medicalCentreId) throws ElementNotFoundException {
        return medicalCentreService.findAllPatientsByMedicalCentre(medicalCentreId)
                .stream()
                .map(patientMapper::patientToPatientResponse)
                .collect(Collectors.toSet());
    }
}
