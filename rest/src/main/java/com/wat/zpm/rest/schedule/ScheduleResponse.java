package com.wat.zpm.rest.schedule;

import com.wat.model.Surgery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {
    private Integer id;
    private List<Surgery> surgeries;
}
