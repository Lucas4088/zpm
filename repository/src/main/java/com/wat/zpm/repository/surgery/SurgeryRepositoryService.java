package com.wat.zpm.repository.surgery;

import com.wat.model.Doctor;
import com.wat.model.Surgery;

import java.util.Set;

public interface SurgeryRepositoryService {
    Set<Surgery> list();

    Surgery findById(int id);

    Set<Surgery> findByIds(Set<Integer> ids);

    Surgery update(Surgery surgery);

    void delete(int id);

    Surgery save(Surgery surgery);
    //TODO save
}
