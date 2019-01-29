package com.wat.zpm.repository;

import com.wat.model.MedicalProcedure;
import com.wat.model.Receptionist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "MedicalCentre")
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCentreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String NIP;
    private String REGON;
    private String bankAccount;
    @OneToOne
    private AddressEntity address;
    @ManyToMany
    private Set<HealthServiceEntity> healthServices;
    @ManyToMany
    private Set<DoctorEntity> doctors;
    @ManyToMany
    private Set<PatientEntity> patients;

    @ManyToMany
    private Set<ReceptionistEntity> receptionists;
    @ManyToMany
    private Set<MedicalProcedureEntity> medicalProcedures;

    private String description;
}
