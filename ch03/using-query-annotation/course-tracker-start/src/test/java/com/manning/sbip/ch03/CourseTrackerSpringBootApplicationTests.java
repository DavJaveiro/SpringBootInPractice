package com.manning.sbip.ch03;

import com.manning.sbip.ch03.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails(){
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(8);
        courseRepository.findAllByCategory("Spring")
                .forEach(course -> System.out.println(course));

        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 4))
                .hasSize(3);
        courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 4).forEach(course -> System.out.println(course));

        assertThat(courseRepository.findAllByRating(5)).hasSize(3);
        courseRepository.findAllByRating(4).forEach(course -> System.out.println(course));

        assertThat(courseRepository.updateRating(1, "Spring Boot with React")).isEqualTo(1);
    }

    @Test
    public void giveACourseAvaibleWhenGetCourseByNameThenGetCourseDescription(){
        Iterable<DescriptionOnly> result = courseRepository.getCourseByName("Rapid Spring Boot Application Development");

        assertThat(result)
                .extracting("description")
                .contains("Spring Boot gives all the power of the Spring Framework without all of the complexity");
    }




}
