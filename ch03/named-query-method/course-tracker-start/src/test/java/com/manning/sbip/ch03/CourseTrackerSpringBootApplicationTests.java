package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCoursesCreateWhenLoadCoursesBySpringCategoryThenExpectThreeCourses() {
        assertThat(courseRepository.findAllByCategoryAndRating("Spring", 4)).hasSize(2);
        assertThat(courseRepository.findAllByCategory("JavaScript")).hasSize(1);
    }

/*
  public List<Course> getCoursesList() {
      Course javaFundamentals = new Course("Java Fundamentals", "Java", 3, "Learn the basics of Java programming and object-oriented concepts.");

      Course springSecurityMastery = new Course("Spring Security Mastery", "Spring", 5, "Master authentication and authorization in Spring Boot applications.");

      Course restfulWebServices = new Course("RESTful Web Services with Spring", "Spring", 4, "Build scalable APIs using Spring Boot and REST principles.");

      Course hibernateDeepDive = new Course("Hibernate Deep Dive", "JPA", 4, "Understand ORM with Hibernate and how to map Java objects to relational databases.");

      Course dockerForJava = new Course("Docker for Java Developers", "DevOps", 3, "Containerize your Java applications using Docker and Docker Compose.");

      Course jpaWithSpringData = new Course("JPA with Spring Data", "Spring", 4, "Leverage Spring Data JPA for powerful database interactions.");

      Course microservicesArchitecture = new Course("Microservices Architecture with Spring Cloud", "Spring", 5, "Design and build microservices with Spring Boot and Spring Cloud.");

      Course testingSpringApps = new Course("Testing Spring Boot Applications", "Testing", 3, "Learn how to write unit and integration tests for Spring applications.");

      Course springBootWithPostgreSQL = new Course("Spring Boot with PostgreSQL", "Databases", 3, "Integrate Spring Boot applications with PostgreSQL databases.");

      Course advancedSpringBoot = new Course("Advanced Spring Boot Techniques", "Spring", 4, "Explore advanced concepts and best practices in Spring Boot development.");

      return Arrays.asList(javaFundamentals, springSecurityMastery, restfulWebServices, hibernateDeepDive, dockerForJava, jpaWithSpringData, microservicesArchitecture, testingSpringApps, springBootWithPostgreSQL, advancedSpringBoot);
  }
*/


}
