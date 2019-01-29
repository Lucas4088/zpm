package com.wat.model.dto;

import com.wat.model.VisitState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessVisitDTO {
    private Integer visitId;
    private VisitState newState;
    private String note;
}
