package com.manning.sbip.ch03.model;

import jdk.jfr.Name;

import javax.persistence.*;

@Entity
@Table(name = "COURSES")
@NamedQueries(
        { @NamedQuery
                ( name = "Course.findAllByRating", query = "select c from Course c where c.rating=?1"),
        @NamedQuery (name = "Course.fidAlBuCategoryAndRating", query = "select c from Course c where c.category=?1 and c.rating=?2")
        }
)
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;

    public Course(){}

    public Course(String name, String category, int rating, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public long getId() {
        return id;
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
    public String toString() {
        return "Course " +
                "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}

