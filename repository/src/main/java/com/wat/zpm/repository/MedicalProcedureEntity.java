package com.wat.zpm.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "MedicalProcedure")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    private Set<EquipmentEntity> equipment;
}
