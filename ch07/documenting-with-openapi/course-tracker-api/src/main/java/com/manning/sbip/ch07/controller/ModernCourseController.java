package com.manning.sbip.ch07.controller;

import com.manning.sbip.ch07.model.ModernCourse;
import com.manning.sbip.ch07.repository.ModernCourseRepository;
import com.manning.sbip.ch07.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses/v2")
public class ModernCourseController {
    private ModernCourseRepository modernCourseRepository;


    @Autowired
    public ModernCourseController(ModernCourseRepository modernCourseRepository) {
        this.modernCourseRepository = modernCourseRepository;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<ModernCourse> getAllCourses() {
        return modernCourseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModernCourse createCourse(@Valid @RequestBody ModernCourse modernCourse) {
        return modernCourseRepository.save(modernCourse);
    }
}
