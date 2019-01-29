package com.wat.zpm.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Entity(name = "Surgery")
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;
    //private boolean available;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalTime startingTime;

    @Column(nullable = false)
    private LocalTime finishingTime;

    private String color;
}
