package com.wat.zpm.repository.equipment;

import com.wat.model.Equipment;
import com.wat.model.HealthInsurance;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class EquipmentRepositoryServiceImpl implements EquipmentRepositoryService {

    private final EquipmentEntityMapper equipmentEntityMapper;
    private final EquipmentRepository equipmentRepository;

    public EquipmentRepositoryServiceImpl(EquipmentEntityMapper equipmentEntityMapper, EquipmentRepository equipmentRepository) {
        this.equipmentEntityMapper = equipmentEntityMapper;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Set<Equipment> list() {
        return equipmentRepository.findAll()
                .stream()
                .map(equipmentEntityMapper::equipmentEntityToEquipment)
                .collect(Collectors.toSet());
    }

    @Override
    public Equipment findById(int id) {
        return equipmentEntityMapper.equipmentEntityToEquipment(
                equipmentRepository.getOne(id));
    }

    @Override
    public Set<Equipment> findByIds(Set<Integer> ids) {
        return equipmentRepository.findAllByIdIn(ids)
                .stream()
                .map(equipmentEntityMapper::equipmentEntityToEquipment)
                .collect(Collectors.toSet());
    }

    @Override
    public Equipment update(Equipment equipment) {
        return null;
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentEntityMapper.equipmentEntityToEquipment(
                equipmentRepository.save(
                        equipmentRepository.save(
                                equipmentEntityMapper.equipmentToEquipmentEntity(equipment)
                        )
                )
        );
    }

}
