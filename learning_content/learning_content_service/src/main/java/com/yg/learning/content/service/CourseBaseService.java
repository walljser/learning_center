package com.yg.learning.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.CreateCourseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.dto.UpdateCourseDto;
import com.yg.learning.content.model.pojo.CourseBase;

public interface CourseBaseService extends IService<CourseBase> {
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseBaseDto queryCourseBaseDto);

    CourseBaseDto createCourseBase(Long companyId, CreateCourseDto createCourseDto);

    CourseBaseDto updateCourseBase(UpdateCourseDto updateCourseDto);

    CourseBaseDto selectByCourseId(Long courseId);
}
