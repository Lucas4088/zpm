package com.wat.zpm.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "NfzDept")
@AllArgsConstructor
@NoArgsConstructor
public class NFZDeptEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String name;
}
