package com.example.Student.Managent.system.repository;

import com.example.Student.Managent.system.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
