package com.wat.zpm.repository.dayvisits;

import com.wat.zpm.repository.DayVisitsEntity;
import com.wat.zpm.repository.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

interface DayVisitsRepository extends JpaRepository<DayVisitsEntity, Integer> {
    Set<DayVisitsEntity> findAllByIdIn(Set<Integer> ids);

    Set<DayVisitsEntity> findAllByDate(LocalDate date);
}
