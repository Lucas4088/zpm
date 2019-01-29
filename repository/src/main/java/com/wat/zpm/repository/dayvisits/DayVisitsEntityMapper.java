package com.wat.zpm.repository.dayvisits;

import com.wat.model.DayVisits;
import com.wat.zpm.repository.DayVisitsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DayVisitsEntityMapper {
    DayVisits dayVisitsEntityToDayVisits(DayVisitsEntity dayVisitsEntity);

    DayVisitsEntity dayVisitsToDayVisitsEntity(DayVisits dayVisits);
}
