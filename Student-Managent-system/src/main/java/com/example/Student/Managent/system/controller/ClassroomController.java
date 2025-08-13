package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.entity.Department;
import com.example.Student.Managent.system.service.ClassroomService;
import com.example.Student.Managent.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private DepartmentService departmentService;

    // Form thêm lớp trong một khoa
    @GetMapping("/add/{departmentId}")
    public String addClassroomForm(@PathVariable("departmentId") Long departmentId, Model model) {
        Classroom classroom = new Classroom();
        Department department = departmentService.getDepartmentById(departmentId);
        classroom.setDepartment(department);
        model.addAttribute("classroom", classroom);
        model.addAttribute("department", department);
            return "Classroom/classroomForm";
    }

    // Lưu lớp mới hoặc cập nhật lớp
    @PostMapping("/save/{departmentId}")
    public String saveClassroom(@PathVariable("departmentId") Long departmentId,
                                @ModelAttribute("classroom") Classroom classroom) {
        Department department = departmentService.getDepartmentById(departmentId);
        classroom.setDepartment(department);
        classroomService.saveClassroom(classroom);
        return "redirect:/departments/" + departmentId + "/classes";
    }

    // Form sửa lớp
    @GetMapping("/edit/{departmentId}/{classId}")
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
    @GetMapping("/delete/{departmentId}/{classId}")
    public String deleteClassroom(@PathVariable("departmentId") Long departmentId,
                                  @PathVariable("classId") Long classId) {
        classroomService.deleteClassroom(classId);
        return "redirect:/departments/" + departmentId + "/classes";
    }
}
