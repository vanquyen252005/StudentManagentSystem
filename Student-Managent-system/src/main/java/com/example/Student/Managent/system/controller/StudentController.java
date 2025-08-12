package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Student;
import com.example.Student.Managent.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
// show Student homePage
    @GetMapping("/students")
    public String viewHomePage(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        return "Student/studentIndex";
    }

    @GetMapping("/students/add")
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "Student/newStudent";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{studentId}")
    public String updateForm(@PathVariable("studentId") Long studentId,Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student",student);
        return "Student/updateStudent";
    }

    @GetMapping("/students/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

}
