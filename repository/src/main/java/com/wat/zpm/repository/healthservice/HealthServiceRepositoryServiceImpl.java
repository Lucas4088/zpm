package com.wat.zpm.repository.healthservice;

import com.wat.model.Doctor;
import com.wat.model.HealthService;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class HealthServiceRepositoryServiceImpl implements HealthServiceRepositoryService {

    private final HealthServiceEntityMapper healthServiceEntityMapper;
    private final HealthServiceRepository healthServiceRepository;

    public HealthServiceRepositoryServiceImpl(HealthServiceEntityMapper healthServiceEntityMapper, HealthServiceRepository healthServiceRepository) {
        this.healthServiceEntityMapper = healthServiceEntityMapper;
        this.healthServiceRepository = healthServiceRepository;
    }

    @Override
    public Set<HealthService> list() {
        return healthServiceRepository.findAll()
                .stream()
                .map(healthServiceEntityMapper::healthServiceEntityToHealthService)
                .collect(Collectors.toSet());
    }

    @Override
    public HealthService findById(int id) {
        return healthServiceEntityMapper.healthServiceEntityToHealthService(healthServiceRepository.getOne(id));
    }

    @Override
    public Set<HealthService> findByIds(Set<Integer> ids) {
        return healthServiceRepository.findAllByIdIn(ids)
                .stream()
                .map(healthServiceEntityMapper::healthServiceEntityToHealthService)
                .collect(Collectors.toSet());
    }

    @Override
    public HealthService update(HealthService healthService) {
        return null;
    }

    @Override
    public HealthService save(HealthService healthService) {
        return healthServiceEntityMapper.healthServiceEntityToHealthService(
                healthServiceRepository.save(
                        healthServiceEntityMapper.healthServiceToHealthServiceEntity(healthService)
                )
        );
    }

}
