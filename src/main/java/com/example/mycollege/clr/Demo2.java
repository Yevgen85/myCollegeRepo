package com.example.mycollege.clr;

import com.example.mycollege.beans.Grade;
import com.example.mycollege.beans.Student;
import com.example.mycollege.dto.GradeByStudentDTO;
import com.example.mycollege.service.CourseService;
import com.example.mycollege.service.GradeService;
import com.example.mycollege.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class Demo2 implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;
    @Override
    public void run(String... args) throws Exception {
        List<Student> students = studentService.getAll();
        students.forEach(System.out::println);
//        studentService.delete(1);
//        courseService.delete(1);
//        gradeService.delete(12);

//        gradeService.getByCourse(2).forEach(System.out::println);

        GradeByStudentDTO.convertToListOfGradesByStudentDTO(gradeService.getByStudent(3)).forEach(System.out::println);
    }

}
