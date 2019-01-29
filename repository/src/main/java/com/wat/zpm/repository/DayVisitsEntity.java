package com.wat.zpm.repository;


import com.wat.model.MedicalCentre;
import com.wat.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "DayVisits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayVisitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<VisitEntity> visits;

    private Integer medicalCentreId;

    private Boolean isAvailable;

    private Integer numberOfVisits;

    private Integer totalNumberOfVisits;
}
