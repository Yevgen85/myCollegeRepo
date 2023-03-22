package com.example.mycollege.service;

import com.example.mycollege.beans.Grade;
import com.example.mycollege.dto.GradeByCourseDTO;
import com.example.mycollege.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final ModelMapper modelMapper;

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    public Grade getOne(int id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade add(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade update(Grade grade, int id) {
        return gradeRepository.save(grade);
    }

    public void delete(int id) {
        gradeRepository.deleteById(id);
    }

    public List<Grade> getByStudent(int studentId) {
        return gradeRepository.findByStudent_Id(studentId);
    }

    public List<Grade> getByCourse(int courseId) {
        return gradeRepository.findByCourse_Id(courseId);
    }



    public double getAverage(int studentId) {

        return gradeRepository.getAverageOfStudentById(studentId).orElse((double) 0);
//        return grades.stream().mapToDouble(Grade::getScore).sum() / grades.size();
    }



    public GradeByCourseDTO convertToGradeByCourseDTO(Grade grade) {
        return modelMapper.map(grade, GradeByCourseDTO.class);
    }

    public List<GradeByCourseDTO> convertToListOfGradesByCourseDTO(List<Grade> grades) {
//        return grades.stream().map(grade -> convertToGradeByCourseDTO(grade)).collect(Collectors.toList());
        return grades.stream().map(this::convertToGradeByCourseDTO).collect(Collectors.toList());
    }
}
