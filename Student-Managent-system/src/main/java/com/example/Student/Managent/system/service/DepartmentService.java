package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.entity.Department;


import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartments();

    public void saveDepartment(Department department);

    public Department getDepartmentById(Long departmentId);

    public void deleteDepartment(Long departmentId);
}
