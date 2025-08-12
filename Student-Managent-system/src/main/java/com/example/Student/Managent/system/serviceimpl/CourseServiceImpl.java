package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Course;
import com.example.Student.Managent.system.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public void saveCourse(Course course) {

    }

    @Override
    public Course getCourseById(Long courseId) {
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {

    }
}
