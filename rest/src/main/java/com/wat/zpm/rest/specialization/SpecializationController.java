package com.wat.zpm.rest.specialization;

import com.wat.zpm.rest.queue.QueueController;
import com.wat.zpm.rest.role.RoleResponse;
import com.wat.zpm.service.SpecializationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(SpecializationController.ENDPOINT)
public class SpecializationController {
    static final String ENDPOINT = "/specialization";

    private final SpecializationService specializationService;
    private final SpecializationMapper specializationMapper;

    public SpecializationController(SpecializationService specializationService, SpecializationMapper specializationMapper) {
        this.specializationService = specializationService;
        this.specializationMapper = specializationMapper;
    }

    @GetMapping(value = "/list")
    @PreAuthorize("hasAuthority('PREVIEW_SPECIALIZATION')")
    public Set<SpecializationResponse> list() {
        return specializationService.list()
                .stream()
                .map(specializationMapper::specializationToSpecializationResponse)
                .collect(Collectors.toSet());
    }

}
