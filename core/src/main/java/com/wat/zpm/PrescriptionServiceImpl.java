package com.wat.zpm;

import com.wat.model.Prescription;
import com.wat.zpm.repository.prescription.PrescriptionRepositoryService;
import com.wat.zpm.service.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepositoryService prescriptionRepositoryService;

    public PrescriptionServiceImpl(PrescriptionRepositoryService prescriptionRepositoryService) {
        this.prescriptionRepositoryService = prescriptionRepositoryService;
    }

    @Override
    public List<Prescription> list() {
        return null;
    }

    @Override
    public Prescription findById(int id) {
        return null;
    }

    @Override
    public Prescription save(Prescription prescription) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
