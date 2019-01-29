package com.wat.zpm.repository.healthinsurance;

import com.wat.model.HealthInsurance;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class HealthInsuranceRepositoryServiceImpl implements HealthInsuranceRepositoryService {

    private final HealthInsuranceEntityMapper healthInsuranceEntityMapper;
    private final HealthInsuranceRepository healthInsuranceRepository;

    public HealthInsuranceRepositoryServiceImpl(HealthInsuranceEntityMapper healthInsuranceEntityMapper, HealthInsuranceRepository healthInsuranceRepository) {
        this.healthInsuranceEntityMapper = healthInsuranceEntityMapper;
        this.healthInsuranceRepository = healthInsuranceRepository;
    }

    @Override
    public Set<HealthInsurance> list() {
        return healthInsuranceRepository.findAll()
                .stream()
                .map(healthInsuranceEntityMapper::healthInsuranceEntityEntityToHealthInsurance)
                .collect(Collectors.toSet());
    }

    @Override
    public HealthInsurance findById(int id) {
        return healthInsuranceEntityMapper.healthInsuranceEntityEntityToHealthInsurance(
                healthInsuranceRepository.getOne(id));
    }

    @Override
    public Set<HealthInsurance> findByIds(Set<Integer> ids) {
        return healthInsuranceRepository.findAllByIdIn(ids)
                .stream()
                .map(healthInsuranceEntityMapper::healthInsuranceEntityEntityToHealthInsurance)
                .collect(Collectors.toSet());
    }

    @Override
    public HealthInsurance update(HealthInsurance healthInsurance) {
        return null;
    }

    @Override
    public HealthInsurance save(HealthInsurance healthInsurance) {
        return healthInsuranceEntityMapper.healthInsuranceEntityEntityToHealthInsurance(
                healthInsuranceRepository.save(
                        healthInsuranceRepository.save(
                                healthInsuranceEntityMapper.healthInsuranceToHealthInsuranceEntity(healthInsurance)
                        )
                )
        );
    }

}
