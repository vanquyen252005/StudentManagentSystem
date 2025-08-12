package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeachers();
    public void saveTeacher(Teacher teacher);
    public Teacher getTeacherById(Long teacherId);
    public void deleteTeacher(Long teacherId);
}
