package com.example.mycollege.controller;

import com.example.mycollege.beans.Grade;
import com.example.mycollege.dto.GradeByCourseDTO;
import com.example.mycollege.dto.GradeByStudentDTO;
import com.example.mycollege.repository.GradeRepository;
import com.example.mycollege.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/grades/")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping()
    public List<Grade> getAllGrades() {
        return gradeService.getAll();
    }

    @GetMapping("byStudent/{id}")
    public List<GradeByStudentDTO> getGradesByStudent(@PathVariable int id) {
        return GradeByStudentDTO.convertToListOfGradesByStudentDTO(gradeService.getByStudent(id));
    }

    @GetMapping("byCourse/{id}")
    public List<GradeByCourseDTO> getGradesByCourse(@PathVariable int id) {
        return gradeService.convertToListOfGradesByCourseDTO(gradeService.getByCourse(id));
    }

    @PostMapping()
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.add(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@RequestBody Grade grade, @PathVariable int id) {
        return gradeService.update(grade, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        gradeService.delete(id);
    }

    @GetMapping("averageBy/{studentId}")
    public double getAverageByStudent(@PathVariable int studentId) {
        return gradeService.getAverage(studentId);
    }
}

