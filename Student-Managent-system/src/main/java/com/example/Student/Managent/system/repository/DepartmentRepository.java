package com.example.Student.Managent.system.repository;

import com.example.Student.Managent.system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
