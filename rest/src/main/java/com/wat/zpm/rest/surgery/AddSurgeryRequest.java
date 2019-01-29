package com.wat.zpm.rest.surgery;

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
public class AddSurgeryRequest {
    @NotNull
    private Integer doctorId;
    @NotNull
    private Integer medicalCentreId;
    @NotNull
    private DayOfWeek dayOfWeek;
    @NotNull
    private LocalTime startsAt;
    @NotNull
    private LocalTime endsAt;
    @NotNull
    private String title;
    @NotNull
    private String color;
}
