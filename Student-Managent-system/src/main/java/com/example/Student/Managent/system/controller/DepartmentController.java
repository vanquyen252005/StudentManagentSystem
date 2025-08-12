package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Department;
import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.service.DepartmentService;
import com.example.Student.Managent.system.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassroomService classroomService;

    // Hiển thị danh sách khoa
    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "Department/departmentIndex";
    }

    // Form thêm mới khoa
    @GetMapping("/add")
    public String addDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "Department/departmentForm";
    }

    // Lưu khoa mới
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    // Form sửa khoa
    @GetMapping("/edit/{departmentId}")
    public String editDepartmentForm(@PathVariable("departmentId") Long departmentId, Model model) {
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department", department);
        return "Department/departmentForm";
    }

    // Xóa khoa
    @GetMapping("/delete/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "redirect:/departments";
    }

    // Hiển thị danh sách lớp trong khoa
    @GetMapping("/{departmentId}/classes")
    public String viewClassesInDepartment(@PathVariable("departmentId") Long departmentId, Model model) {
        Department department = departmentService.getDepartmentById(departmentId);
        List<Classroom> classes =classroomService.getClassesByDepartmentId(departmentId);

        model.addAttribute("department", department);
        model.addAttribute("classes", classes);

        return "Classroom/classroomIndex";
    }
}
