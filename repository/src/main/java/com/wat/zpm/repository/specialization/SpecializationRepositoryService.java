package com.wat.zpm.repository.specialization;

import com.wat.model.Receptionist;
import com.wat.model.Specialization;

import java.util.Set;

public interface SpecializationRepositoryService {
    Set<Specialization> list();

    Specialization findById(int id);

    Set<Specialization> findByIds(Set<Integer> ids);

    Specialization update(Specialization specialization);

    Specialization save(Specialization specialization);
}
