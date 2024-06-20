package com.manish.quickstart.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getCourseList(String id) {
        return new ArrayList<>(courseRepository.findByTopicId(id));
    }

    public Course getCourse(String courseId) {
        return courseRepository.findById(courseId).get();
    }

    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void updateCourse(Course topic) {
        courseRepository.save(topic);
    }


    public void deleteCourse(String id) {
        courseRepository.deleteById(id);

    }
}
