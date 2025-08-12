package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.entity.Department;
import com.example.Student.Managent.system.repository.ClassroomRepository;
import com.example.Student.Managent.system.repository.DepartmentRepository;
import com.example.Student.Managent.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent()) {
            return department.get();
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
