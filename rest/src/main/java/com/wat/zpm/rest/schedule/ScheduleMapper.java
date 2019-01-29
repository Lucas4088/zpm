package com.wat.zpm.rest.schedule;

import com.wat.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleMapper {
    ScheduleResponse scheduleToScheduleResponse(Schedule schedule);
}
