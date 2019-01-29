package com.wat.zpm.repository.schedule;

import com.wat.model.Schedule;
import com.wat.model.Surgery;

import java.util.Set;

public interface ScheduleRepositoryService {
    Set<Schedule> list();

    Schedule findById(int id);

    Set<Schedule> findByIds(Set<Integer> ids);

    Schedule update(Schedule surgery);

    void delete(int id);

    Schedule save(Schedule surgery);

    //TODO save
}
