package com.manning.sbip.ch03.repository;

import com.manning.sbip.ch03.model.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, QuerydslPredicateExecutor<Course> {

    @Query("select c from Course c where c.category=?1")
    Iterable<Course> findAllByCategory(String category);

    @Query("select c from Course c where c.category=?1 and c.rating>?2")
    Iterable<Course> findAllByCategoryAndRatingGreaterThan(String category, Double rating);

    @Modifying
    @Transactional
    @Query("update Course c set c.rating=?1 where c.name=?2")
    void updateRating(String category, Double rating);

}
