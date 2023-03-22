package com.example.mycollege.repository;

import com.example.mycollege.beans.Grade;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"student", "course"})
    List<Grade> findAll();
    List<Grade> findByStudent_Id(int id);

    List<Grade> findByCourse_Id(int id);

    @Query(value = "SELECT AVG(score) FROM college.grade WHERE student_id = ?", nativeQuery = true)
    Optional<Double> getAverageOfStudentById(int id);
}
