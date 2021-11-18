package com.engage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engage.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
