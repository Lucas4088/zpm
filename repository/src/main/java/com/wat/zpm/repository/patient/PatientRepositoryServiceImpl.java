package com.wat.zpm.repository.patient;

import com.wat.model.Doctor;
import com.wat.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class PatientRepositoryServiceImpl implements PatientRepositoryService {

    private final PatientEntityMapper patientEntityMapper;
    private final PatientRepository patientRepository;

    public PatientRepositoryServiceImpl(PatientEntityMapper patientEntityMapper, PatientRepository patientRepository) {
        this.patientEntityMapper = patientEntityMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    public Set<Patient> list() {
        return patientRepository.findAll()
                .stream()
                .map(patientEntityMapper::patientEntityToPatient)
                .collect(Collectors.toSet());
    }

    @Override
    public Patient findById(int id) {
        return patientEntityMapper.patientEntityToPatient(patientRepository.getOne(id));
    }

    @Override
    public Set<Patient> findByIds(Set<Integer> ids) {
        return null;/* patientRepository.findAllByIdIn(ids)
                .stream()
                .map(patientEntityMapper::patientEntityToPatient)
                .collect(Collectors.toSet());*/
    }

    @Override
    public Patient update(Patient doctor) {
        return null;
    }

}
