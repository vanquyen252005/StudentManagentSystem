package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.entity.Department;
import com.example.Student.Managent.system.entity.Student;
import com.example.Student.Managent.system.service.ClassroomService;
import com.example.Student.Managent.system.service.DepartmentService;
import com.example.Student.Managent.system.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/api/classes")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StudentService studentService;

    // Form thêm lớp trong một khoa
    @GetMapping("{departmentId}/add")
    public String addClassroomForm(@PathVariable("departmentId") Long departmentId, Model model) {
        Classroom classroom = new Classroom();
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("classroom", classroom);
        model.addAttribute("department", department);
            return "Classroom/classroomForm";
    }

    // Lưu lớp mới hoặc cập nhật lớp
    @PostMapping("{departmentId}/save")
    public String saveClassroom(@PathVariable("departmentId") Long departmentId,
                                @ModelAttribute("classroom") Classroom classroom) {
        Department department = departmentService.getDepartmentById(departmentId);
        classroom.setDepartment(department);
        classroomService.saveClassroom(classroom);
        return "redirect:/api/departments/" + departmentId + "/classes";
    }

    // Form sửa lớp
    @GetMapping("/{departmentId}/{classId}/edit")
    public String editClassroomForm(@PathVariable("departmentId") Long departmentId,
                                    @PathVariable("classId") Long classId,
                                    Model model) {
        Classroom classroom = classroomService.getClassroomById(classId);
        Department department = departmentService.getDepartmentById(departmentId);

        model.addAttribute("classroom", classroom);
        model.addAttribute("department", department);
        return "Classroom/classroomForm";
    }

    // Xóa lớp
    @GetMapping("/{departmentId}/{classId}/delete")
    public String deleteClassroom(@PathVariable("departmentId") Long departmentId,
                                  @PathVariable("classId") Long classId) {
        classroomService.deleteClassroomByClassId(classId);
        return "redirect:/api/departments/" + departmentId + "/classes";
    }
    // Show tat ca sinh vien trong lop
    @GetMapping("/{classId}/students")
    public String viewAllStudentsInClass(@PathVariable("classId") Long classId,
                                          Model model) {
        Classroom classroom = classroomService.getClassroomById(classId);
        List<Student> students = studentService.findByClassroomId(classId);
        model.addAttribute("classroom", classroom);
        model.addAttribute("students", students);
        return "Student/studentIndex";
    }
}
