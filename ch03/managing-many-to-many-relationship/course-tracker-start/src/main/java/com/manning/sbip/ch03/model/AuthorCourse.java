package com.manning.sbip.ch03.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AUTHOR_COURSES")
@Table(name = "AUTHORS_COURSES")
public class AuthorCourse {

    @Id
    @Column(name = "author_id")
    private long authorId;

    @Column(name = "course_id")
    private long courseId;

    public AuthorCourse() {}

    public AuthorCourse(long authorId, long courseId) {
        this.authorId = authorId;
        this.courseId = courseId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getCourseId() {
        return courseId;
    }
}
