package com.wat.zpm.repository.visit;

import com.wat.model.Visit;
import com.wat.model.VisitState;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
class VisitRepositoryServiceImpl implements VisitRepositoryService {

    private final VisitEntityMapper visitEntityMapper;
    private final VisitRepository visitRepository;

    public VisitRepositoryServiceImpl(VisitEntityMapper visitEntityMapper, VisitRepository visitRepository) {
        this.visitEntityMapper = visitEntityMapper;
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> list() {
        return visitRepository.findAll()
                .stream()
                .map(visitEntityMapper::visitEntityToVisit)
                .collect(Collectors.toSet());
    }

    @Override
    public Visit findById(int id) {
        return visitEntityMapper.visitEntityToVisit(visitRepository.getOne(id));
    }

    @Override
    public Set<Visit> findByIds(Set<Integer> ids) {
        return visitRepository.findAllByIdIn(ids)
                .stream()
                .map(visitEntityMapper::visitEntityToVisit)
                .collect(Collectors.toSet());
    }

    @Override
    public Visit update(Visit visit) {
        return null;
    }

    @Override
    public Visit save(Visit visit) {
        return visitEntityMapper.visitEntityToVisit(
                visitRepository.save(
                        visitEntityMapper.visitToVisitEntity(visit)
                )
        );
    }

    @Override
    public Set<Visit> findByPatientId(Integer patientId) {
        return visitRepository.findAllByPatientId(patientId)
                .stream()
                .map(visitEntityMapper::visitEntityToVisit)
                .collect(Collectors.toSet());

    }

    @Override
    public Set<Visit> getAllByMedicalCentre(Integer medicalCentreId) {
        return visitRepository.findAllByMedicalCentreId(medicalCentreId)
                .stream()
                .map(visitEntityMapper::visitEntityToVisit)
                .collect(Collectors.toSet());
    }
}
