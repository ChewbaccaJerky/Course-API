package com.chewbaccajerky.course;

import com.chewbaccajerky.core.BaseEntity;
import com.chewbaccajerky.review.Review;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity{

    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    private String url;

    // Cascade - If Course is deleted all of it's reviews are deleted also
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
