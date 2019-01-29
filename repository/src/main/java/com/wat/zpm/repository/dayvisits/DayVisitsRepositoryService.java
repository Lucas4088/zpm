package com.wat.zpm.repository.dayvisits;

import com.wat.model.DayVisits;
import com.wat.model.Prescription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface DayVisitsRepositoryService {
    Set<DayVisits> list();

    DayVisits findById(int id);

    Set<DayVisits> findByIds(Set<Integer> ids);

    DayVisits update(DayVisits dayVisits);

    DayVisits save(DayVisits dayVisits);

    Set<DayVisits> findAllByDate(LocalDate date);
}
