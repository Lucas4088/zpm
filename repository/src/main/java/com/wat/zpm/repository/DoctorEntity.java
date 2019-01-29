package com.wat.zpm.repository;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "Doctor")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue(value = "DOCTOR")
public class DoctorEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private Integer pwz;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ScheduleEntity> schedules;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SpecializationEntity> specializations;
    private String description;
    private Long lengthOfVisit;
    /*@ManyToMany
    private Set<MedicalCentreEntity> medicalCentres;*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DayVisitsEntity> dayVisits;

    public DoctorEntity(String firstName, String lastName, Integer pwz, Set<ScheduleEntity> schedules, Set<SpecializationEntity> specializations, String description, Long lengthOfVisit, Set<DayVisitsEntity> dayVisits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pwz = pwz;
        this.schedules = schedules;
        this.specializations = specializations;
        this.description = description;
        this.lengthOfVisit = lengthOfVisit;
        this.dayVisits = dayVisits;
    }
}
