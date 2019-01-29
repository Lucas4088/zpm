package com.wat.zpm.repository.doctor;

import com.wat.model.Doctor;
import com.wat.model.Role;

import java.util.Set;

public interface DoctorRepositoryService {
    Set<Doctor> list();

    Doctor findById(int id);

    Set<Doctor> findByIds(Set<Integer> ids);

    Doctor update(Doctor doctor);

    Doctor save(Doctor doctor);
}
