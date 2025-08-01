package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Student;
import com.example.Student.Managent.system.repository.StudentRepository;
import com.example.Student.Managent.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
    return (List<Student>) studentRepository.findAll();
    }

    @Override
    public String postStudent(Student student) {
         studentRepository.save(student);
         return "Post Student successfully";
    }

    @Override
    public String updateStudent(Student student, Long studentId) {
        Student updateStudent = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getLastName()) && !student.getLastName().trim().isEmpty()) {
            updateStudent.setLastName(student.getFirstName());
        }
        if(Objects.nonNull(student.getFirstName()) && !student.getFirstName().trim().isEmpty()) {
            updateStudent.setFirstName(student.getFirstName());
        }

        if(Objects.nonNull(student.getEmail()) && !student.getEmail().trim().isEmpty()) {
            updateStudent.setEmail(student.getEmail());
        }
        studentRepository.save(updateStudent);
        return "Update Student succesfully";
    }

    @Override
    public String deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Delete Student successfully";
    }
}
