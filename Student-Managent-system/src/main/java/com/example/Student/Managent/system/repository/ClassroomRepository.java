package com.example.Student.Managent.system.repository;

import com.example.Student.Managent.system.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    public List<Classroom> findByDepartmentId(Long departmentId);
}
