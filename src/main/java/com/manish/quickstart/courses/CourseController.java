package com.manish.quickstart.courses;

import com.manish.quickstart.Controllers.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getCourses(@PathVariable String id) {
        return courseService.getCourseList(id);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
