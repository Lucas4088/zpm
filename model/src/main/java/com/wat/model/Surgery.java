package com.wat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surgery {
    private Integer Id;
    private DayOfWeek dayOfWeek;
    private String title;
    //private boolean available;
    private LocalTime startingTime;
    private LocalTime finishingTime;
    private String color;
}
