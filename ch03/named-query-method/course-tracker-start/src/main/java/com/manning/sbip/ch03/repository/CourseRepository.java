package com.manning.sbip.ch03.repository;

import com.manning.sbip.ch03.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Iterable<Course> findAllByCategory(String category);
    Iterable<Course> findAllByCategoryAndRating(String category, int rating);
}
