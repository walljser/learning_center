package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yg.learning.content.mapper.CourseTeacherMapper;
import com.yg.learning.content.model.pojo.CourseTeacher;
import com.yg.learning.content.service.CourseTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher> implements CourseTeacherService {
    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> selectCourseTeachListByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseTeacher> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CourseTeacher::getCourseId, courseId);
        List<CourseTeacher> courseTeachers = courseTeacherMapper.selectList(lqw);
        return courseTeachers;
    }

    @Override
    public void saveCourseTeacher(CourseTeacher saveCourseTeacher) {
        Long id = saveCourseTeacher.getId();
        if (id == null) {
            courseTeacherMapper.insert(saveCourseTeacher);
        } else {
            courseTeacherMapper.updateById(saveCourseTeacher);
        }
    }
}
