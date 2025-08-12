package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Teacher;
import com.example.Student.Managent.system.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Teacher> getAllTeachers() {
        return List.of();
    }

    @Override
    public void saveTeacher(Teacher teacher) {

    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return null;
    }

    @Override
    public void deleteTeacher(Long teacherId) {

    }
}
