package com.wat.zpm.repository.schedule;

import com.wat.model.Schedule;
import com.wat.zpm.repository.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleEntityMapper {
    Schedule scheduleEntityToSchedule(ScheduleEntity scheduleEntity);

    ScheduleEntity scheduleToScheduleEntity(Schedule schedule);
}
