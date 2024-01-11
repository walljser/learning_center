package com.yg.learning.content.service;

import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.pojo.CourseBase;

public interface CourseBaseService {
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseBaseDto queryCourseBaseDto);
}
