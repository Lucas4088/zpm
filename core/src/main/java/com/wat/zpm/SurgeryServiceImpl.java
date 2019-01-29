package com.wat.zpm;

import com.wat.model.Surgery;
import com.wat.zpm.repository.surgery.SurgeryRepositoryService;
import com.wat.zpm.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepositoryService surgeryRepositoryService;

    public SurgeryServiceImpl(SurgeryRepositoryService surgeryRepositoryService) {
        this.surgeryRepositoryService = surgeryRepositoryService;
    }

    @Override
    public List<Surgery> list() {
        return null;
    }

    @Override
    public Surgery findById(int id) {
        return null;
    }

    @Override
    public Surgery save(Surgery surgery) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
