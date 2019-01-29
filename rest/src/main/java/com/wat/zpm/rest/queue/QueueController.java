package com.wat.zpm.rest.queue;

import com.wat.model.dto.QueueParametersDTO;
import com.wat.model.exception.ElementNotFoundException;
import com.wat.zpm.service.QueueService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(QueueController.ENDPOINT)
public class QueueController {
    static final String ENDPOINT = "/queue";

    private final QueueService queueService;
    private final QueueMapper queueMapper;

    public QueueController(QueueService queueService, QueueMapper queueMapper) {
        this.queueService = queueService;
        this.queueMapper = queueMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PREVIEW_QUEUE')")
    public List<QueueResponse> list(@RequestParam Integer specializationId,
                                    @RequestParam(required = false) Integer medicalCentreId,
                                    @RequestParam Set<String> voievodeship) throws ElementNotFoundException {
        return queueService.getQueues(new QueueParametersDTO(
                specializationId,
                medicalCentreId,
                voievodeship)).stream()
                .map(queueMapper::queueToQueueResponse)
                .collect(Collectors.toList());
    }

}
