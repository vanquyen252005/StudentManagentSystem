package com.example.Student.Managent.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semester;
    private String academic_year;
    private Double grade;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

}
