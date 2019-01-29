package com.wat.zpm.rest.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayVisitsResponse {
    private Integer id;
    private LocalDate localDate;

    private Boolean isAvailable;

    private Integer numberOfVisits;

    private Integer totalNumberOfVisits;
}
