package com.chewbaccajerky.review;

import com.chewbaccajerky.core.BaseEntity;
import com.chewbaccajerky.course.Course;

import javax.persistence.*;

@Entity
public class Review extends BaseEntity {

    // TODO: csd - We are duplicating code for every Entity

    private int rating;
    private String description;

    @ManyToOne
    private Course course;


    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
}
