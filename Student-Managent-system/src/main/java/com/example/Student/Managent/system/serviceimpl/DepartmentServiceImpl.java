package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Department;
import com.example.Student.Managent.system.repository.DepartmentRepository;
import com.example.Student.Managent.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Managent.system.exception.DepartmentAlreadyExistException;
import com.example.Student.Managent.system.exception.NoSuchDepartmentExistsException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }
    @Override
    public void saveDepartment(Department department) {
        Optional<Department> optional = departmentRepository.findById(department.getId());
        if (optional.isPresent()) {
            Department existingDepartment = optional.get();
            departmentRepository.save(existingDepartment);
        } else {
            throw new DepartmentAlreadyExistException("Department already exists!");
        }
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                       .orElseThrow(() -> new NoSuchDepartmentExistsException("Department not found with ID: " + departmentId));
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Optional<Department> optional = departmentRepository.findById(departmentId);
        if(optional.isPresent()) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new NoSuchDepartmentExistsException("Department not found with ID: " + departmentId);
        }
    }
}
