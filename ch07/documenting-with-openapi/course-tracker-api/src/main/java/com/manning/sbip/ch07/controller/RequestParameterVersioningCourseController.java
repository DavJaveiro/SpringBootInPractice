package com.manning.sbip.ch07.controller;

import com.manning.sbip.ch07.model.Course;
import com.manning.sbip.ch07.model.ModernCourse;
import com.manning.sbip.ch07.repository.ModernCourseRepository;
import com.manning.sbip.ch07.service.CourseService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses/")
public class RequestParameterVersioningCourseController {

    private CourseService courseService;
    private ModernCourseRepository modernCourseRepository;

    public RequestParameterVersioningCourseController(CourseService couseService, ModernCourseRepository modernCourseRepository) {
        this.courseService = couseService;
        this.modernCourseRepository = modernCourseRepository;
    }

    @GetMapping(params= "version=v1")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Course> getAllLegacyCourses() {
        return courseService.getCourses();
    }

    @PostMapping(params = "version=v1")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping(params = "version=v2")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<ModernCourse> getAllModernCourses() {
        return modernCourseRepository.findAll();
    }

    @PostMapping(params = "version=v2")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModernCourse createModernCourse(@Valid @RequestBody ModernCourse modernCourse) {
        return modernCourseRepository.save(modernCourse);
    }
}
