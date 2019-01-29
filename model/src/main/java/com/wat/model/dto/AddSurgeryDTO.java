package com.wat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSurgeryDTO {
    private Integer doctorId;
    private DayOfWeek dayOfWeek;
    private LocalTime startsAt;
    private LocalTime endsAt;
    private String title;
    private String color;
    private Integer medicalCentreId;
}
