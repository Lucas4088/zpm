package com.wat.zpm.repository.surgery;

import com.wat.model.Doctor;
import com.wat.model.Surgery;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class SurgeryRepositoryServiceImpl implements SurgeryRepositoryService {

    private final SurgeryEntityMapper surgeryEntityMapper;
    private final SurgeryRepository surgeryRepository;

    public SurgeryRepositoryServiceImpl(SurgeryEntityMapper surgeryEntityMapper, SurgeryRepository surgeryRepository) {
        this.surgeryEntityMapper = surgeryEntityMapper;
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public Set<Surgery> list() {
        return surgeryRepository.findAll()
                .stream()
                .map(surgeryEntityMapper::surgeryEntityToSurgery)
                .collect(Collectors.toSet());
    }

    @Override
    public Surgery findById(int id) {
        return surgeryEntityMapper.surgeryEntityToSurgery(surgeryRepository.getOne(id));
    }

    @Override
    public Set<Surgery> findByIds(Set<Integer> ids) {
        return surgeryRepository.findAllByIdIn(ids)
                .stream()
                .map(surgeryEntityMapper::surgeryEntityToSurgery)
                .collect(Collectors.toSet());
    }

    @Override
    public Surgery update(Surgery surgery) {
        return null;
    }

    @Override
    public void delete(int id) {
        surgeryRepository.deleteById(id);
    }

    @Override
    public Surgery save(Surgery surgery) {
        return surgeryEntityMapper.surgeryEntityToSurgery(surgeryRepository.save(
                surgeryEntityMapper.surgeryToSurgeryEntity(surgery)
        ));
    }
}
