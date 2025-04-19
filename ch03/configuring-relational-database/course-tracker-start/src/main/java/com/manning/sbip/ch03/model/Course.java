package com.manning.sbip.ch03.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;

    public Course(String name, String category, int rating, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    // no args constructor
    public Course() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return rating == course.rating && Objects.equals(Id, course.Id) && Objects.equals(name, course.name) && Objects.equals(category, course.category) && Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, category, rating, description);
    }
}
