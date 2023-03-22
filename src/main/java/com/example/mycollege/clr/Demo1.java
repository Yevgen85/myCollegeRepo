package com.example.mycollege.clr;

import com.example.mycollege.beans.Course;
import com.example.mycollege.beans.Grade;
import com.example.mycollege.beans.Student;
import com.example.mycollege.repository.GradeRepository;
import com.example.mycollege.service.CourseService;
import com.example.mycollege.service.GradeService;
import com.example.mycollege.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(1)
public class Demo1 implements CommandLineRunner {
    Random random = new Random();
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;

    @Override
    public void run(String... args) throws Exception {

        fillDb();
    }

    private void fillDb() {
        List<Course> courseList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            Course course = new Course();
            course.setName("Course_" + i);
            courseService.add(course);
            courseList.add(course);
        }

        for (int i = 1; i <= 100; i++) {
            Student student = Student.builder().
                    age(random.nextInt(13) + 18).
                    firstName("First_Name_" + i).
                    lastName("Last_Name_" + i).isActive(true).createdAt(LocalDateTime.now()).build();
            studentService.add(student);

            for (int j = 1; j <= 5; j++) {
                Grade grade = new Grade();
                grade.setCourse(courseList.get(j - 1));
                grade.setStudent(student);
                grade.setScore(random.nextInt(41) + 60);
                gradeService.add(grade);
            }
        }
    }
}

