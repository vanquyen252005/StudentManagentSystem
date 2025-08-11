package com.example.Student.Managent.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String code;
     private String name;
     private Long credit;
     @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;
     @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Registration> registrations;
}
