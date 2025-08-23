package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Classroom;

import java.util.List;

public interface ClassroomService {
    public List<Classroom> getAllClassrooms();
    public void saveClassroom(Classroom classroom);
    public Classroom getClassroomById(Long classroomId);
    public void deleteClassroomByClassId(Long classroomId);
    public List<Classroom> getClassesByDepartmentId(Long departmentId);
}
