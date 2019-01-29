package com.wat.zpm.repository.receptionist;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.ReceptionistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface ReceptionistRepository extends JpaRepository<ReceptionistEntity, Integer> {
    //Set<DoctorEntity> findAllByIdIn(Set<Integer> ids);
}
