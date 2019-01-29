package com.wat.zpm.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class QueueEntity {
    private int numberOfPatients;
    private LocalDateTime availableDate;
}
