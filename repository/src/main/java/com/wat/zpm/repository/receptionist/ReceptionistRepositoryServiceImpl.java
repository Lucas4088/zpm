package com.wat.zpm.repository.receptionist;

import com.wat.model.Receptionist;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class ReceptionistRepositoryServiceImpl implements ReceptionistRepositoryService {

    private final ReceptionistEntityMapper receptionistEntityMapper;
    private final ReceptionistRepository receptionistRepository;

    public ReceptionistRepositoryServiceImpl(ReceptionistEntityMapper receptionistEntityMapper, ReceptionistRepository receptionistRepository) {
        this.receptionistEntityMapper = receptionistEntityMapper;
        this.receptionistRepository = receptionistRepository;
    }

    @Override
    public Set<Receptionist> list() {
        return receptionistRepository.findAll()
                .stream()
                .map(receptionistEntityMapper::receptionistEntityToReceptionist)
                .collect(Collectors.toSet());
    }

    @Override
    public Receptionist findById(int id) {
        return receptionistEntityMapper.receptionistEntityToReceptionist(receptionistRepository.getOne(id));
    }

    @Override
    public Set<Receptionist> findByIds(Set<Integer> ids) {
        return null;/*receptionistRepository.findAllByIdIn(ids)
                .stream()
                .map(receptionistEntityMapper::doctorEntityToDoctor)
                .collect(Collectors.toSet());*/
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        return null;
    }

    @Override
    public Receptionist save(Receptionist doctor) {
        return receptionistEntityMapper.receptionistEntityToReceptionist(
                receptionistRepository.save(
                        receptionistEntityMapper.receptionistToReceptionistEntity(doctor)
                )
        );
    }

}
