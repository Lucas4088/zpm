package com.wat.zpm.repository.medicalcentre;

import com.wat.model.Doctor;
import com.wat.model.MedicalCentre;
import com.wat.zpm.repository.doctor.DoctorEntityMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
class MedicalCentreRepositoryServiceImpl implements MedicalCentreRepositoryService {

    private final MedicalCentreEntityMapper medicalCentreEntityMapper;
    private final MedicalCentreRepository medicalCentreRepository;
    private final DoctorEntityMapper doctorEntityMapper;

    public MedicalCentreRepositoryServiceImpl(MedicalCentreEntityMapper medicalCentreEntityMapper, MedicalCentreRepository medicalCentreRepository, DoctorEntityMapper doctorEntityMapper) {
        this.medicalCentreEntityMapper = medicalCentreEntityMapper;
        this.medicalCentreRepository = medicalCentreRepository;
        this.doctorEntityMapper = doctorEntityMapper;
    }

    @Override
    public Set<MedicalCentre> list() {
        return medicalCentreRepository.findAll()
                .stream()
                .map(medicalCentreEntityMapper::medicalCentreEntityToMedicalCentre)
                .collect(Collectors.toSet());
    }

    @Override
    public MedicalCentre findById(int id) throws EntityNotFoundException {
        return medicalCentreEntityMapper.medicalCentreEntityToMedicalCentre(
                medicalCentreRepository.getOne(id));
    }

    @Override
    public Set<MedicalCentre> findByIds(Set<Integer> ids) {
        return medicalCentreRepository.findAllByIdIn(ids)
                .stream()
                .map(medicalCentreEntityMapper::medicalCentreEntityToMedicalCentre)
                .collect(Collectors.toSet());
    }

    @Override
    public MedicalCentre update(MedicalCentre medicalCentre) {
        return medicalCentreEntityMapper.medicalCentreEntityToMedicalCentre(
                medicalCentreRepository.save(
                        medicalCentreRepository.save(
                                medicalCentreEntityMapper.medicalCentreToMedicalCentreEntity(medicalCentre)
                        )
                )
        );
    }

    @Override
    public MedicalCentre save(MedicalCentre medicalCentre) {
        return medicalCentreEntityMapper.medicalCentreEntityToMedicalCentre(
                medicalCentreRepository.save(
                        medicalCentreRepository.save(
                                medicalCentreEntityMapper.medicalCentreToMedicalCentreEntity(medicalCentre)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        medicalCentreRepository.deleteById(id);
    }

    @Override
    public Set<MedicalCentre> findAllByLocality(String locality) {
        return medicalCentreRepository.findAllByAddress_Locality(locality)
                .stream()
                .map(medicalCentreEntityMapper::medicalCentreEntityToMedicalCentre)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> findAllMedicalCentreLocalities() {
        return medicalCentreRepository.findAll()
                .stream()
                .map(medicalCentre -> medicalCentre.getAddress()
                        .getLocality())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Doctor> findAllDoctorsByMedicalCentre(int id) {
        return medicalCentreRepository.getOne(id)
                .getDoctors()
                .stream()
                .map(doctorEntityMapper::doctorEntityToDoctor)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<MedicalCentre> findAllByVoievodeship(Set<String> veoievodeships) {
        return medicalCentreRepository.findAllByAddress_VoievodeshipIn(veoievodeships)
                .stream()
                .map(medicalCentreEntityMapper::medicalCentreEntityToMedicalCentre)
                .collect(Collectors.toSet());
    }

}
