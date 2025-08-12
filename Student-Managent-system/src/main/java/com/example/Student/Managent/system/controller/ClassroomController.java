package com.example.Student.Managent.system.controller;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;
    @GetMapping
    public String ListClassrooms(Model model) {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        return "Classroom/classroomIndex";
    }

    @GetMapping("/add")
    public String addClassroomForm(Model model) {
        model.addAttribute("classroom",new Classroom());
        return "Classroom/classroomForm";
    }

    @PostMapping("/save")
    public String saveClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.saveClassroom(classroom);
        return "redirect:/classrooms";
    }
}
