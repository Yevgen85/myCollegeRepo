package com.example.mycollege.repository;

import com.example.mycollege.beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
