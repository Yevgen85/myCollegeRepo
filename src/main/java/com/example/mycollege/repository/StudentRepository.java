package com.example.mycollege.repository;

import com.example.mycollege.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    List<Student> findByFirstNameStartingWith(String startWith);
}
