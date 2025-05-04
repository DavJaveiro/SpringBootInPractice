package com.manning.sbip.ch03;

import com.manning.sbip.ch03.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void whenCountAllCOursesThenExpectFiveCourses() {
        assertThat(authorRepository.getAuthorCourseInfo(2)).hasSize(3);
    }
}
