package com.yg.learning.content.web;

import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.CreateCourseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.dto.UpdateCourseDto;
import com.yg.learning.content.model.pojo.CourseBase;
import com.yg.learning.content.service.CourseBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CourseBaseController {
    @Autowired
    private CourseBaseService courseBaseService;

    @PostMapping("/course/list")
    public PageResult<CourseBase> pageList(PageParams pageParams, @RequestBody(required = false) QueryCourseBaseDto queryCourseBaseDto) {
        return courseBaseService.queryCourseBaseList(pageParams, queryCourseBaseDto);
    }

    @PostMapping("/course")
    public CourseBaseDto createCourseBase(@Valid @RequestBody CreateCourseDto createCourseDto) {
        Long companyId = 1232141425L;
        return courseBaseService.createCourseBase(companyId, createCourseDto);
    }

    @PutMapping("/course")
    public CourseBaseDto updateCourseBase(@Valid @RequestBody UpdateCourseDto updateCourseDto) {
        return courseBaseService.updateCourseBase(updateCourseDto);
    }

    @GetMapping("/course/{courseId}")
    public CourseBaseDto getCourseBaseInfo(@PathVariable Long courseId) {
        return courseBaseService.selectByCourseId(courseId);
    }
}
