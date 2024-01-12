package com.yg.learning.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yg.learning.content.model.pojo.CourseTeacher;

import java.util.List;

public interface CourseTeacherService extends IService<CourseTeacher> {
    List<CourseTeacher> selectCourseTeachListByCourseId(Long courseId);

    void saveCourseTeacher(CourseTeacher saveCourseTeacher);
}
