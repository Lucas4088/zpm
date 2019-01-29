package com.wat.zpm.rest.queue;

import com.wat.model.MedicalCentre;
import com.wat.model.Queue;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QueueMapper {
    QueueResponse queueToQueueResponse(Queue queue);
}
