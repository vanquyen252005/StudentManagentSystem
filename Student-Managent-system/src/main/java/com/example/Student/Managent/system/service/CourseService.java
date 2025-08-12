package com.example.Student.Managent.system.service;

import com.example.Student.Managent.system.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();
    public void saveCourse(Course course);
    public Course getCourseById(Long courseId);
    public void deleteCourse(Long courseId);
}
