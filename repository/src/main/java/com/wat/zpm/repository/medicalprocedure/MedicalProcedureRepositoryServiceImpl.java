package com.wat.zpm.repository.medicalprocedure;

import com.wat.model.MedicalProcedure;
import com.wat.zpm.repository.healthinsurance.HealthInsuranceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class MedicalProcedureRepositoryServiceImpl implements MedicalProcedureRepositoryService {

    private final MedicalProcedureEntityMapper medicalProcedureEntityMapper;
    private final MedicalProcedureRepository medicalProcedureRepository;

    public MedicalProcedureRepositoryServiceImpl(MedicalProcedureEntityMapper medicalProcedureEntityMapper, MedicalProcedureRepository medicalProcedureRepository) {
        this.medicalProcedureEntityMapper = medicalProcedureEntityMapper;
        this.medicalProcedureRepository = medicalProcedureRepository;
    }

    @Override
    public Set<MedicalProcedure> list() {
        return medicalProcedureRepository.findAll()
                .stream()
                .map(medicalProcedureEntityMapper::medicalProcedureEntityToMedicalProcedure)
                .collect(Collectors.toSet());
    }

    @Override
    public MedicalProcedure findById(int id) {
        return medicalProcedureEntityMapper.medicalProcedureEntityToMedicalProcedure(
                medicalProcedureRepository.getOne(id));
    }

    @Override
    public Set<MedicalProcedure> findByIds(Set<Integer> ids) {
        return null;
    }

    @Override
    public MedicalProcedure update(MedicalProcedure medicalProcedure) {
        return null;
    }

    @Override
    public MedicalProcedure save(MedicalProcedure medicalProcedure) {
        return medicalProcedureEntityMapper.medicalProcedureEntityToMedicalProcedure(
                medicalProcedureRepository.save(
                        medicalProcedureRepository.save(
                                medicalProcedureEntityMapper.medicalProcedureToMedicalProcedureEntity(medicalProcedure)
                        )
                )
        );
    }

}
