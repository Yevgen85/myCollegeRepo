package com.example.mycollege.dto;

import com.example.mycollege.beans.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {




    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public static StudentDTO convertToDTO(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentDTO.class);
    }

    public static List<StudentDTO> convertToListOfDTO(List<Student> students) {
        List<StudentDTO> convertedStudents = new ArrayList<>();
        students.forEach(student -> convertedStudents.add(convertToDTO(student)));
        return convertedStudents;
    }
}
