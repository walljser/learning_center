package com.yg.learning.content.web;

import com.yg.learning.content.model.pojo.CourseTeacher;
import com.yg.learning.content.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseTeacherController {
    @Autowired
    private CourseTeacherService courseTeacherService;

    @GetMapping("/courseTeacher/list/{courseId}")
    public List<CourseTeacher> getCourseTeachList(@PathVariable Long courseId) {
        return courseTeacherService.selectCourseTeachListByCourseId(courseId);
    }

    @PostMapping("/courseTeacher")
    public void saveCourseTeacher(@RequestBody CourseTeacher courseTeacher) {
        courseTeacherService.saveCourseTeacher(courseTeacher);
    }
}
