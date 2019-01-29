package com.wat.zpm.rest.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCancelVisitRequest {
    private String stateNote;
}
