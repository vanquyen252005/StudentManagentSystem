package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.entity.Student;
import com.example.Student.Managent.system.service.ClassroomService;
import com.example.Student.Managent.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;

    // Form thêm mới sinh viên
    @GetMapping("/{classId}/add")
    public String addStudentForm(@PathVariable("classId") Long classId,
                                  Model model) {
        Classroom classroom = classroomService.getClassroomById(classId);
        model.addAttribute("student", new Student());
        model.addAttribute("classroom", classroom);
        return "Student/studentForm";
    }

    // Lưu sinh viên mới
    @PostMapping("/{classId}/save")
    public String saveStudent(@PathVariable("classId") Long classId,
                               @ModelAttribute("student") Student student) {
        Classroom classroom = classroomService.getClassroomById(classId);
        student.setClassroom(classroom);
        studentService.saveStudent(student);
        return "redirect:/api/classes/" + classId + "/students";
    }

    // Form sửa sinh viên
    @GetMapping("/{classroomId}/{studentId}/edit")
    public String editStudentForm(@PathVariable("classroomId") Long classroomId,
                                   @PathVariable("studentId") Long studentId,
                                   Model model) {
        Classroom classroom = classroomService.getClassroomById(classroomId);
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("classroom", classroom);
        model.addAttribute("student", student);
        return "Student/studentForm";
    }

    // Xóa sinh viên
    @GetMapping("/{classroomId}/{studentId}/delete")
    public String deleteStudent(@PathVariable("classroomId") Long classroomId,
                                 @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/api/classes/" + classroomId + "/students";
    }

}
