package com.yg.learning.content.web;

import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.pojo.CourseBase;
import com.yg.learning.content.service.CourseBaseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseBaseController {
    @Autowired
    private CourseBaseService courseBaseService;

    @GetMapping("/courses")
    public PageResult<CourseBase> pageList(PageParams pageParams, @RequestBody(required = false) QueryCourseBaseDto queryCourseBaseDto) {
        return courseBaseService.queryCourseBaseList(pageParams, queryCourseBaseDto);
    }
}
