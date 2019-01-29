package com.wat.zpm.repository.visit;

import com.wat.model.VisitState;
import com.wat.zpm.repository.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

interface VisitRepository extends JpaRepository<VisitEntity, Integer> {
    Set<VisitEntity> findAllByIdIn(Set<Integer> ids);

    Set<VisitEntity> findAllByPatientId(Integer patientId);

    Set<VisitEntity> findAllByMedicalCentreId(Integer medicalCentreId);
}
