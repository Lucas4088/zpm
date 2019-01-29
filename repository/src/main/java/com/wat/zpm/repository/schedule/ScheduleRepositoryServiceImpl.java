package com.wat.zpm.repository.schedule;

import com.wat.model.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class ScheduleRepositoryServiceImpl implements ScheduleRepositoryService {

    private final ScheduleEntityMapper scheduleEntityMapper;
    private final ScheduleRepository scheduleRepository;

    public ScheduleRepositoryServiceImpl(ScheduleEntityMapper scheduleEntityMapper, ScheduleRepository scheduleRepository) {

        this.scheduleEntityMapper = scheduleEntityMapper;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Set<Schedule> list() {
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleEntityMapper::scheduleEntityToSchedule)
                .collect(Collectors.toSet());
    }

    @Override
    public Schedule findById(int id) {
        return scheduleEntityMapper.scheduleEntityToSchedule(scheduleRepository.getOne(id));
    }

    @Override
    public Set<Schedule> findByIds(Set<Integer> ids) {
        return null;/*scheduleRepository.findAllByIdIn(ids)
                .stream()
                .map(surgeryEntityMapper::surgeryEntityToSurgery)
                .collect(Collectors.toSet());*/
    }

    @Override
    public Schedule update(Schedule schedule) {
        return null;
    }

    @Override
    public void delete(int id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleEntityMapper.scheduleEntityToSchedule(scheduleRepository.save(
                scheduleEntityMapper.scheduleToScheduleEntity(schedule)
        ));
    }

}
