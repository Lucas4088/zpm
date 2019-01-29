package com.wat.zpm.repository.medicalcentre;

import com.wat.zpm.repository.MedicalCentreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

interface MedicalCentreRepository extends JpaRepository<MedicalCentreEntity, Integer> {
    Set<MedicalCentreEntity> findAllByIdIn(Set<Integer> ids);

    Set<MedicalCentreEntity> findAllByAddress_Locality(String locality);

    Set<MedicalCentreEntity> findAllByAddress_VoievodeshipIn(Set<String> voievodeships);
}
