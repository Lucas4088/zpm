package com.wat.zpm.repository.prescription;

import com.wat.model.Doctor;
import com.wat.model.Prescription;

import java.util.Set;

public interface PrescriptionRepositoryService {
    Set<Prescription> list();

    Prescription findById(int id);

    Set<Prescription> findByIds(Set<Integer> ids);

    Prescription update(Prescription prescription);
}
