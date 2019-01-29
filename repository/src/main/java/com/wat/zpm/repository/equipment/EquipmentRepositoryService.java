package com.wat.zpm.repository.equipment;

import com.wat.model.Equipment;
import com.wat.model.HealthInsurance;

import java.util.Set;

public interface EquipmentRepositoryService {
    Set<Equipment> list();

    Equipment findById(int id);

    Set<Equipment> findByIds(Set<Integer> ids);

    Equipment update(Equipment equipment);

    Equipment save(Equipment equipment);

}
