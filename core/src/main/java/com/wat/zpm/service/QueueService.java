package com.wat.zpm.service;

import com.wat.model.Queue;
import com.wat.model.dto.QueueParametersDTO;
import com.wat.model.exception.ElementNotFoundException;

import java.util.List;

public interface QueueService {
    List<Queue> getQueues(QueueParametersDTO queueParametersDTO) throws ElementNotFoundException;
}
