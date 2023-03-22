package com.example.mycollege.service;

import com.example.mycollege.beans.Student;
import com.example.mycollege.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getOne(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student, int id) {
        return studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
