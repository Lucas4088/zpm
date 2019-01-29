package com.wat.zpm.repository.equipment;

import com.wat.model.Equipment;
import com.wat.zpm.repository.EquipmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipmentEntityMapper {
    Equipment equipmentEntityToEquipment(EquipmentEntity equipmentEntity);

    EquipmentEntity equipmentToEquipmentEntity(Equipment equipment);
}
