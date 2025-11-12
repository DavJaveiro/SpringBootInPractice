package com.manning.sbip.ch07.repository;

import com.manning.sbip.ch07.model.ModernCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModernCourseRepository extends CrudRepository<ModernCourse, Long> {

}
