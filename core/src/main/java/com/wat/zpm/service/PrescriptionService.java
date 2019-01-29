package com.wat.zpm.service;

import com.wat.model.Prescription;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> list();

    Prescription findById(int id);

    Prescription save(Prescription prescription);

    void delete(int id);
}
