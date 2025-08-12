package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Schedule;
import com.example.Student.Managent.system.service.ScheduleService;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<Schedule> getAllSchedules() {
        return List.of();
    }

    @Override
    public void saveSchedule(Schedule schedule) {

    }

    @Override
    public Schedule getScheduleById(Long scheduleId) {
        return null;
    }

    @Override
    public void deleteSchedule(Long scheduleId) {

    }
}
