package com.example.Student.Managent.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Date hire_date;
    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Course> courses;
}
