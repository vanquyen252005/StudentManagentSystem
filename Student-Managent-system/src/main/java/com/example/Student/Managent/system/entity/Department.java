package com.example.Student.Managent.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String officeLocation;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classroom> classrooms;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "department" ,cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

}
