package com.wat.zpm.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "Schedule")
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<SurgeryEntity> surgeries = new HashSet<>();

    private Integer medicalCentreId;
}
