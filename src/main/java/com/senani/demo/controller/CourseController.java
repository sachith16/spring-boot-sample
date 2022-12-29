package com.senani.demo.controller;

import com.senani.demo.exception.ApiErrors;
import com.senani.demo.exception.ApiExceptions;
import com.senani.demo.exception.ApiRequestException;
import com.senani.demo.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1, "English"),
                new Course(2, "Maths"),
                new Course(3, "Science")
        );
    }

    @RequestMapping("/course")
    public List<Course> getCourseById() {
        System.out.println("Request for /api/v1/course");
        throw ApiExceptions.COURSE_NOT_FOUND;
    }
}
