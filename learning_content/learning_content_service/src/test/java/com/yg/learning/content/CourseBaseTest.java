package com.yg.learning.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.mapper.CourseBaseMapper;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.pojo.CourseBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseBaseTest {
    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Test
    public void testQuery() {
        QueryCourseBaseDto queryCourseBaseDto = new QueryCourseBaseDto();
        queryCourseBaseDto.setCourseName("java");

        LambdaQueryWrapper<CourseBase> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(queryCourseBaseDto.getCourseName()), CourseBase::getName, queryCourseBaseDto.getCourseName());
        lqw.eq(StringUtils.isNotEmpty(queryCourseBaseDto.getAuditStatus()), CourseBase::getAuditStatus, queryCourseBaseDto.getAuditStatus());

        PageParams pageParams = new PageParams();
        pageParams.setPageNo(4L);
        pageParams.setPageSize(2L);

        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, lqw);

        List<CourseBase> courseBases = pageResult.getRecords();
//        for (CourseBase courseBase: courseBases) {
//            System.out.println(courseBase);
//        }
        PageResult<CourseBase> courseBasePageResult = new PageResult<>(courseBases, pageResult.getTotal(), pageParams.getPageNo(), pageParams.getPageSize());
        System.out.println(courseBasePageResult);
    }
}
