package com.wat.zpm.rest.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueRequest {
    Integer specializationId;
    Integer medicalCentreId;
    List<String> voievodeship;
}
