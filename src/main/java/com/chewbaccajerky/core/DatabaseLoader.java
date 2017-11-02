package com.chewbaccajerky.core;

import com.chewbaccajerky.course.Course;
import com.chewbaccajerky.course.CourseRepository;
import com.chewbaccajerky.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courses;

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course = new Course("Java", "https://www.tutorialspoint.com/java/");
        course.addReview(new Review(5, "Great tutorial! Very informative!"));

        String templates[] = {
                "Up and running with %s",
                "Built my first app with %s",
                "%s is great!",
                "%s is so confusing....",
                "I love %s, it's so easy to understand!"
        };

        String buzzwords[] = {
                "Java",
                "C++",
                "Ruby",
                "Javascript",
                "Python"
        };

        List<Course> bunchOfCourses = new ArrayList<>();

        IntStream.range(1, 100)
                .forEach(i -> {
                   String template = templates[i % templates.length];
                   String buzzword = buzzwords[i % buzzwords.length];
                   String title = String.format(template, buzzword);
                   Course c = new Course(title, "http://example.com");
                   c.addReview(new Review( i % 5, String.format("More %s please!!!", buzzword)));
                   bunchOfCourses.add(c);
                });
        courses.save(bunchOfCourses);
        courses.save(course);
    }

}
