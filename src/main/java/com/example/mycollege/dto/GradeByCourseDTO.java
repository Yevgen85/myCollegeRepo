package com.example.mycollege.dto;

import com.example.mycollege.beans.Course;
import com.example.mycollege.beans.Grade;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeByCourseDTO {
    private String studentName;
    private int score;

}

