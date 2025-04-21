package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void givenDataAvaibleWhenLoadFirstPageThenGetFiveRecords() {
        Pageable pageable = PageRequest.of(0, 5);
        assertThat(courseRepository.findAll(pageable)).hasSize(5);
        assertThat(pageable.getPageNumber()).isEqualTo(0);

        courseRepository.findAll(pageable).forEach(course -> {
            System.out.println(course + "\n");
        });

        Pageable nextPageable = pageable.next();

        courseRepository.findAll(nextPageable).forEach(course ->
                System.out.println(course + "\n"));

        assertThat(courseRepository.findAll(nextPageable)).hasSize(4);
        assertThat(nextPageable.getPageNumber()).isEqualTo(1);

    }

    @Test
    public void givenDataAvaibleWhenSortsFirstPageThenGetSortedsData() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("rating")));

        Condition<Course> sortedFirstCourseCondition = new Condition<Course>() {

            @Override
            public boolean matches(Course course) {
                return course.getId() == 4 && course.getName().equals("Cloud Native Spring Boot Application Development");
            }
        };

        assertThat(courseRepository.findAll(pageable)).first().has(sortedFirstCourseCondition);

    }


    public void givenDataAvailableWhenApplyCustomSortThenGetSortedResult() {
        Pageable customSortPageable = PageRequest.of(0,5, Sort.by("Ratinng").descending().and(Sort.by("Name")));

        Condition<Course> customSortFirstCourseCondition = new Condition<Course>() {

            @Override
            public boolean matches(Course course) {
                return course.getId() == 2 && course.getName().equals("Getting Started with Spring Security DSL");
            }
        };

        assertThat(courseRepository.findAll(customSortPageable)).first().has(customSortFirstCourseCondition);

    }



}
