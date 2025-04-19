package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

/*    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails() throws SQLException {
        assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
        assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("MySQL");
    }*/

    @Autowired
    private CourseRepository courseRepository;

    // create
    @Test
    public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the " +
                "Spring Framework without all of the complexities");
                Course savedCourse = courseRepository.save(course);

                assertThat(courseRepository.findById(savedCourse.getId()).get()).isEqualTo(course);
    }

    // update
    @Test
    public void givenUpdateCourseWhenLoadTheCourseThenExpectUpdateCourse() {
        Course course = new Course("Rapid Spring Boot Application Development",
                "Spring", 4,
                "Spring Boot gives all the power of the Spring Framework Without all of the complexities");
                courseRepository.save(course);
                course.setRating(5);
                Course savedCourse = courseRepository.save(course);

                assertThat(courseRepository.findById(savedCourse.getId()).get().getRating()).isEqualTo(5);
    }

    // delete
    @Test
    public void givenDeleteCourseWhenLoadTheCourseThenExpectDeleteCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework Without all of the complexities");
            Course savedCourse = courseRepository.save(course);
            assertThat(courseRepository.findById(savedCourse.getId()).get()).isEqualTo(course);
            courseRepository.delete(savedCourse);

            assertThat(courseRepository.findById(savedCourse.getId()).isPresent()).isFalse();
    }
}
