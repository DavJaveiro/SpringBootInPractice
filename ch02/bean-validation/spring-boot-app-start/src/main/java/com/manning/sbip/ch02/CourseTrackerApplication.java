package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.validation.Validator;

@RestController
@SpringBootApplication
public class CourseTrackerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Course course = new Course();
        course.setId(1);
        course.setName("Spring Boot In Practice");
        course.setRating(0); // create a course with a rating of 0, which violates the minimum constraint defined for the rating filed
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Course>> violations = validator.validate(course);

        violation
    }



}