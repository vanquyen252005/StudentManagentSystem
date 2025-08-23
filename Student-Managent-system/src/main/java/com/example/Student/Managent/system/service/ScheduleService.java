package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    public List<Schedule> getAllSchedules();
    public void saveSchedule(Schedule schedule);
    public Schedule getScheduleById(Long scheduleId);
    public void deleteSchedule(Long scheduleId);
}
