package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Student;
import com.example.Student.Managent.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
@Autowired
    private StudentService studentService;
@GetMapping("Students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }
    @PostMapping("/Students")
    public String postStudent(@RequestBody Student student) {
        return studentService.postStudent(student);
    }
    @PutMapping("/Students/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable("id") Long studentId){
    return studentService.updateStudent(student,studentId);
    }
    @DeleteMapping("Students/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId) {
    return studentService.deleteStudent(studentId);
    }
}
