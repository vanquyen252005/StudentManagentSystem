package com.example.Student.Managent.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Timer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long day_of_week;
    private LocalTime start_time;
    private LocalTime end_time;
    private String day;
    private String room;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

}
