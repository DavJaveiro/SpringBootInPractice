package com.manning.sbip.ch08.repository;

import com.manning.sbip.ch08.model.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course, String> {
	Flux<Course> findAllByCategory(String category);
	Flux<Course> findAllByAuthor(String author);
}
