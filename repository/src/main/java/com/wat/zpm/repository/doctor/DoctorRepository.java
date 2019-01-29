package com.wat.zpm.repository.doctor;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    //Set<DoctorEntity> findAllByIdIn(Set<Integer> ids);
}
