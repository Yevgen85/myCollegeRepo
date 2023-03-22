package com.example.mycollege.dto;

import com.example.mycollege.beans.Grade;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
public class GradeByStudentDTO {
    private String courseName;
    private int score;

    public static GradeByStudentDTO convertToGradeByStudentDTO(Grade grade) {
        return GradeByStudentDTO.builder().
                courseName(grade.getCourse().getName()).
                score(grade.getScore()).
                build();
    }

    public static List<GradeByStudentDTO> convertToListOfGradesByStudentDTO(List<Grade> grades) {
        List<GradeByStudentDTO> gradesList = new ArrayList<>();
        grades.forEach(grade -> gradesList.add(convertToGradeByStudentDTO(grade)));
        return gradesList;
    }
}



