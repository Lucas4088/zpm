package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayVisits {
    private Integer id;

    private LocalDate date;
    private List<Visit> visits;

    private Integer medicalCentreId;

    private Boolean isAvailable;

    private Integer numberOfVisits;

    private Integer totalNumberOfVisits;
}
