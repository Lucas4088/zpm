package com.wat.zpm.repository.dayvisits;

import com.wat.model.DayVisits;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
class DayVisitsRepositoryServiceImpl implements DayVisitsRepositoryService {

    private final DayVisitsEntityMapper dayVisitsEntityMapper;
    private final DayVisitsRepository dayVisitsRepository;

    public DayVisitsRepositoryServiceImpl(DayVisitsEntityMapper dayVisitsEntityMapper, DayVisitsRepository dayVisitsRepository) {
        this.dayVisitsEntityMapper = dayVisitsEntityMapper;
        this.dayVisitsRepository = dayVisitsRepository;
    }

    @Override
    public Set<DayVisits> list() {
        return dayVisitsRepository.findAll()
                .stream()
                .map(dayVisitsEntityMapper::dayVisitsEntityToDayVisits)
                .collect(Collectors.toSet());
    }

    @Override
    public DayVisits findById(int id) {
        return dayVisitsEntityMapper.dayVisitsEntityToDayVisits(dayVisitsRepository.getOne(id));
    }

    @Override
    public Set<DayVisits> findByIds(Set<Integer> ids) {
        return dayVisitsRepository.findAllByIdIn(ids)
                .stream()
                .map(dayVisitsEntityMapper::dayVisitsEntityToDayVisits)
                .collect(Collectors.toSet());
    }

    @Override
    public DayVisits update(DayVisits dayVisits) {
        return null;
    }

    @Override
    public DayVisits save(DayVisits dayVisits) {
        return dayVisitsEntityMapper.dayVisitsEntityToDayVisits(
                dayVisitsRepository.save(dayVisitsEntityMapper.dayVisitsToDayVisitsEntity(
                        dayVisits
                ))
        );
    }

    @Override
    public Set<DayVisits> findAllByDate(LocalDate date) {
        return  dayVisitsRepository.findAllByDate(date)
                .stream()
                .map(dayVisitsEntityMapper::dayVisitsEntityToDayVisits)
                .collect(Collectors.toSet());
    }

    //TODO save
}
