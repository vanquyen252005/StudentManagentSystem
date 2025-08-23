package com.example.Student.Managent.system.repository;

import com.example.Student.Managent.system.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByClassroomId(Long classroomId);
}
    