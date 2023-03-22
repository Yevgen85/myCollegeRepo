package com.example.mycollege.controller;

import com.example.mycollege.beans.Student;
import com.example.mycollege.dto.StudentDTO;
import com.example.mycollege.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students/")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    List<StudentDTO> getAllStudents() {
        return StudentDTO.convertToListOfDTO(studentService.getAll());
    }
}
