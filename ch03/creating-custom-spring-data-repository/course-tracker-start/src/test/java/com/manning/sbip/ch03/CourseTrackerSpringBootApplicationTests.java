package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CustomizedCourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CourseTrackerSpringBootApplicationTests {

    /*A anotação @Autowired no Spring Framework é usada para habilitar a injeção de dependência
    * Isso significa que o Spring é responsável por instanciar e injetar automaticamente um objeto
    * necessário em outro objeto, eliminando a necessidade de criar instânciar manualmente no código*/
    @Autowired
    private CustomizedCourseRepository customizedCourseRepository;

    @Test
    public void givenCreateTwoCoursesWhenFindAllCoursesThenExpectTwoCourses() {

        // 1) O teste cria um objeto
        Course course1 = new Course("Rapid Spring Boot Application Development", "Spring", 4, "...");
        Course course2 = new Course("Teste Spring Boot Application Development", "Spring", 4, "...");

        // 2) Salva usando o repositório customizado
        customizedCourseRepository.save(course1);


        assertThat(Arrays.asList(customizedCourseRepository.findAll()).size()).isEqualTo(1);
    }
}
