package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Student;

import java.util.List;

public interface StudentService {
     public List<Student> getAllStudents();
     public String postStudent(Student student);
     public String updateStudent(Student student, Long studentId);
     public String deleteStudent(Long studentId);
}
