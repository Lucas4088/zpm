package com.wat.zpm.repository.receptionist;

import com.wat.model.Doctor;
import com.wat.model.Receptionist;

import java.util.Set;

public interface ReceptionistRepositoryService {
    Set<Receptionist> list();

    Receptionist findById(int id);

    Set<Receptionist> findByIds(Set<Integer> ids);

    Receptionist update(Receptionist receptionist);

    Receptionist save(Receptionist receptionist);
}
