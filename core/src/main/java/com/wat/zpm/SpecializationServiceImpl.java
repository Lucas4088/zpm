package com.wat.zpm;

import com.wat.model.Specialization;
import com.wat.zpm.repository.specialization.SpecializationRepositoryService;
import com.wat.zpm.service.SpecializationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepositoryService specializationRepositoryService;

    public SpecializationServiceImpl(SpecializationRepositoryService specializationRepositoryService) {
        this.specializationRepositoryService = specializationRepositoryService;
    }

    @Override
    public Set<Specialization> list() {
        return specializationRepositoryService.list();
    }
}
