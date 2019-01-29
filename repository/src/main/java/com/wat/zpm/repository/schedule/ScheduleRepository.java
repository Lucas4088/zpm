package com.wat.zpm.repository.schedule;

import com.wat.model.Schedule;
import com.wat.zpm.repository.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
}
