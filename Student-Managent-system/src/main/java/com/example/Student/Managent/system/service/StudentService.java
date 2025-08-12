package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Student;

import java.util.List;

public interface StudentService {
     public List<Student> getAllStudents();
     public void saveStudent(Student student);
     public Student getStudentById(Long studentId);
     public void deleteStudent(Long studentId);
}
