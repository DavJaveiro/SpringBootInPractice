package com.manning.sbip.ch03.repository;

import com.manning.sbip.ch03.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // indicando que é um repositório Spring
public interface CourseRepository extends CrudRepository<Course, Long> {
    /*Embora esteja vazia
    * em tempo de execução sua implementação concreta é fornecida
    * pelo Spring Data JPA, que então é usada para executar
    * as operações CRUD.*/

}
