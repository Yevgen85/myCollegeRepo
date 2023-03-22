package com.example.mycollege.service;

import com.example.mycollege.beans.Course;
import com.example.mycollege.beans.Grade;
import com.example.mycollege.repository.CourseRepository;
import com.example.mycollege.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getOne(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course, int id) {
        return courseRepository.save(course);
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }

}
