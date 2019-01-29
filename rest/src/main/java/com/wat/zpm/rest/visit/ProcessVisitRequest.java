package com.wat.zpm.rest.visit;

import com.wat.model.VisitState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessVisitRequest {
    private Integer visitId;
    private VisitState newState;
    private String note;
}
