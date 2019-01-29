package com.wat.zpm.rest.surgery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryResponse {
    private Integer Id;
    private DayOfWeek dayOfWeek;
    //private boolean available;
    private LocalTime startingTime;
    private LocalTime finishingTime;
    private Boolean isAvailable;
    private Integer numberOfVisit;
}
