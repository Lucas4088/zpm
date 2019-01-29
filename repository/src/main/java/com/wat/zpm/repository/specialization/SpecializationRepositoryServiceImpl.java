package com.wat.zpm.repository.specialization;

import com.wat.model.Receptionist;
import com.wat.model.Specialization;
import com.wat.zpm.repository.receptionist.ReceptionistEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class SpecializationRepositoryServiceImpl implements SpecializationRepositoryService {

    private final SpecializationEntityMapper specializationEntityMapper;
    private final SpecializationRepository specializationRepository;

    public SpecializationRepositoryServiceImpl(SpecializationEntityMapper specializationEntityMapper, SpecializationRepository specializationRepository) {
        this.specializationEntityMapper = specializationEntityMapper;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public Set<Specialization> list() {
        return specializationRepository.findAll()
                .stream()
                .map(specializationEntityMapper::specializationEntityToSpecialization)
                .collect(Collectors.toSet());
    }

    @Override
    public Specialization findById(int id) {
        return specializationEntityMapper.specializationEntityToSpecialization(specializationRepository.getOne(id));
    }

    @Override
    public Set<Specialization> findByIds(Set<Integer> ids) {
        return null;/*specializationRepository.findAllByIdIn(ids)
                .stream()
                .map(receptionistEntityMapper::doctorEntityToDoctor)
                .collect(Collectors.toSet());*/
    }

    @Override
    public Specialization update(Specialization receptionist) {
        return null;
    }

    @Override
    public Specialization save(Specialization doctor) {
        return specializationEntityMapper.specializationEntityToSpecialization(
                specializationRepository.save(
                        specializationEntityMapper.specializationToSpecializationEntity(doctor)
                )
        );
    }

}
