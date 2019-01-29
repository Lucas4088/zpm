package com.wat.zpm.repository.prescription;

import com.wat.model.Doctor;
import com.wat.model.Prescription;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class PrescriptionRepositoryServiceImpl implements PrescriptionRepositoryService {

    private final PrescriptionEntityMapper prescriptionEntityMapper;
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionRepositoryServiceImpl(PrescriptionEntityMapper prescriptionEntityMapper, PrescriptionRepository prescriptionRepository) {
        this.prescriptionEntityMapper = prescriptionEntityMapper;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Set<Prescription> list() {
        return prescriptionRepository.findAll()
                .stream()
                .map(prescriptionEntityMapper::prescriptionEntityToPrescription)
                .collect(Collectors.toSet());
    }

    @Override
    public Prescription findById(int id) {
        return prescriptionEntityMapper.prescriptionEntityToPrescription(prescriptionRepository.getOne(id));
    }

    @Override
    public Set<Prescription> findByIds(Set<Integer> ids) {
        return prescriptionRepository.findAllByIdIn(ids)
                .stream()
                .map(prescriptionEntityMapper::prescriptionEntityToPrescription)
                .collect(Collectors.toSet());
    }

    @Override
    public Prescription update(Prescription prescription) {
        return null;
    }

    //TODO save
}
