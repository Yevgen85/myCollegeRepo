package com.example.mycollege.controller;

import com.example.mycollege.beans.Course;
import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.service.CourseService;
import com.example.mycollege.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/courses/")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    List<Course> getAllCourses() {
        return courseService.getAll();
    }
}
