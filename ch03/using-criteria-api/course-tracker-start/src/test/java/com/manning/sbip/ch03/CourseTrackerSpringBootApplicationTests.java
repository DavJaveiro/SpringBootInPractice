package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.repository.CourseRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;

//    @Test
//    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {
//
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Course> courseCriteriaQuery = criteriaBuilder.createQuery(Course.class);
//
//        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
//
//        Predicate courseCategoryPredicate = criteriaBuilder.equal(courseRoot.get("category"), "Spring");
//
//        courseCriteriaQuery.where(courseCategoryPredicate);
//
//        TypedQuery<Course> query = entityManager.createQuery(courseCriteriaQuery);
//
//        Assertions.assertThat(query.getResultList().size()).isEqualTo(3);
//    }

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectedResult() {
        QCourse course = QCourse.course;

        JPAQuery query1 = new JPAQuery(entityManager);
        query1.from(course).where(course.category.eq("Spring"));

        assertThat(query1.fetch().size()).isEqualTo(3);

    }

}
