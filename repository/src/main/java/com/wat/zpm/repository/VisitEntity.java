package com.wat.zpm.repository;

import com.wat.model.Equipment;
import com.wat.model.VisitState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity(name = "Visit")
@AllArgsConstructor
@NoArgsConstructor
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate dayOfTheVisit;
    @Column(nullable = false)
    private LocalTime startOfTheVisit;
    @Column(nullable = false)
    private LocalTime endOfTheVisit;
    @Column(nullable = false)
    private LocalDateTime dateOfCreation;
    @Column(nullable = false)
    private Integer medicalCentreId;
    @Column(nullable = false)
    private Integer doctorId;

    @Enumerated(value = EnumType.STRING)
    private VisitState visitState;

    @OneToOne
    private MedicalProcedureEntity medicalProcedure;

    private LocalDateTime newRequestedDate;

    private Integer newDoctorId;

    private LocalDate newDayOfTheVisit;
    private LocalTime newStartOfTheVisit;

    @Column(length = 1000)
    private String stateNote;

    @OneToOne
    private PatientEntity patient;

    @ManyToMany
    private Set<EquipmentEntity> equipment;
}
