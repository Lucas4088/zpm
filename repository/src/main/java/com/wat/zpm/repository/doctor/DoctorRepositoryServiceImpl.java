package com.wat.zpm.repository.doctor;

import com.wat.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class DoctorRepositoryServiceImpl implements DoctorRepositoryService {

    private final DoctorEntityMapper doctorEntityMapper;
    private final DoctorRepository doctorRepository;

    public DoctorRepositoryServiceImpl(DoctorEntityMapper doctorEntityMapper, DoctorRepository doctorRepository) {
        this.doctorEntityMapper = doctorEntityMapper;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Set<Doctor> list() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorEntityMapper::doctorEntityToDoctor)
                .collect(Collectors.toSet());
    }

    @Override
    public Doctor findById(int id) {
        return doctorEntityMapper.doctorEntityToDoctor(doctorRepository.getOne(id));
    }

    @Override
    public Set<Doctor> findByIds(Set<Integer> ids) {
        return null;/*doctorRepository.findAllByIdIn(ids)
                .stream()
                .map(doctorEntityMapper::doctorEntityToDoctor)
                .collect(Collectors.toSet());*/
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorEntityMapper.doctorEntityToDoctor(
                doctorRepository.save(
                        doctorEntityMapper.doctorToDoctorEntity(doctor)
                )
        );
    }

}
