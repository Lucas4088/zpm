package com.wat.zpm.repository.nfzdept;

import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.NFZDeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

interface NFZDeptRepository extends JpaRepository<NFZDeptEntity, Integer> {
    Set<NFZDeptEntity> findAllByIdIn(Set<Integer> ids);
}
