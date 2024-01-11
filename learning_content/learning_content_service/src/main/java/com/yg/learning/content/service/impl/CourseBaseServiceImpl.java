package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.mapper.CourseBaseMapper;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.pojo.CourseBase;
import com.yg.learning.content.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseBaseServiceImpl implements CourseBaseService {
    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseBaseDto queryCourseBaseDto) {
        LambdaQueryWrapper<CourseBase> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(queryCourseBaseDto.getCourseName()), CourseBase::getName, queryCourseBaseDto.getCourseName());
        lqw.eq(StringUtils.isNotEmpty(queryCourseBaseDto.getAuditStatus()), CourseBase::getAuditStatus, queryCourseBaseDto.getAuditStatus());
        lqw.eq(StringUtils.isNotEmpty(queryCourseBaseDto.getPublishStatus()), CourseBase::getStatus, queryCourseBaseDto.getPublishStatus());

        Page<CourseBase> courseBasePage = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> result = courseBaseMapper.selectPage(courseBasePage, lqw);

        List<CourseBase> list = result.getRecords();

        PageResult<CourseBase> pageResult = new PageResult<>();
        pageResult.setItems(list);
        pageResult.setTotal(result.getTotal());
        pageResult.setPageNo(pageParams.getPageNo());
        pageResult.setPageSize(pageParams.getPageSize());

        return pageResult;
    }
}
