package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yg.learning.base.exception.LearningException;
import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.mapper.CourseBaseMapper;
import com.yg.learning.content.mapper.CourseCategoryMapper;
import com.yg.learning.content.mapper.CourseMarketMapper;
import com.yg.learning.content.model.dto.CourseBaseDto;
import com.yg.learning.content.model.dto.CreateCourseDto;
import com.yg.learning.content.model.dto.QueryCourseBaseDto;
import com.yg.learning.content.model.dto.UpdateCourseDto;
import com.yg.learning.content.model.pojo.CourseBase;
import com.yg.learning.content.model.pojo.CourseCategory;
import com.yg.learning.content.model.pojo.CourseMarket;
import com.yg.learning.content.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements CourseBaseService {
    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Autowired
    private CourseMarketMapper courseMarketMapper;

    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

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
        pageResult.setCounts(result.getTotal());
        pageResult.setPageNo(pageParams.getPageNo());
        pageResult.setPageSize(pageParams.getPageSize());

        return pageResult;
    }

    @Override
    public CourseBaseDto createCourseBase(Long companyId, CreateCourseDto createCourseDto) {
        CourseBase courseBaseNew = new CourseBase();
        BeanUtils.copyProperties(createCourseDto, courseBaseNew);
        courseBaseNew.setCompanyId(companyId);
        courseBaseNew.setCreateDate(LocalDateTime.now());
        courseBaseNew.setAuditStatus("202002");
        courseBaseNew.setStatus("203001");

        int insert = courseBaseMapper.insert(courseBaseNew);
        if (insert <= 0) {
            LearningException.cast("新增课程信息失败");
        }

        CourseMarket courseMarketNew = new CourseMarket();
        BeanUtils.copyProperties(createCourseDto, courseMarketNew);
        courseMarketNew.setId(courseBaseNew.getId());
        saveCourseMarketInfo(courseMarketNew);

        CourseBaseDto courseBaseDtoInfo = getCourseBaseDtoInfo(courseBaseNew.getId());
        return courseBaseDtoInfo;
    }

    @Override
    public CourseBaseDto updateCourseBase(UpdateCourseDto updateCourseDto) {
        Long courseId = updateCourseDto.getId();

        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (courseBase == null) {
            LearningException.cast("没有找到课程信息");
        }

        BeanUtils.copyProperties(updateCourseDto, courseBase);
        courseBaseMapper.updateById(courseBase);

        CourseMarket courseMarket = new CourseMarket();
        BeanUtils.copyProperties(updateCourseDto, courseMarket);
        saveCourseMarketInfo(courseMarket);

        CourseBaseDto courseBaseDtoInfo = getCourseBaseDtoInfo(courseId);
        return courseBaseDtoInfo;
    }

    @Override
    public CourseBaseDto selectByCourseId(Long courseId) {
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        CourseBaseDto courseBaseDto = new CourseBaseDto();
        BeanUtils.copyProperties(courseBase, courseBaseDto);

        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        if (courseMarket != null) {
            BeanUtils.copyProperties(courseMarket, courseBaseDto);
        }
        return courseBaseDto;
    }

    private CourseBaseDto getCourseBaseDtoInfo(Long courseId) {
        CourseBase courseBase = courseBaseMapper.selectById(courseId);

        if (courseBase == null) {
            return null;
        }
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);

        CourseBaseDto courseBaseDto = new CourseBaseDto();
        BeanUtils.copyProperties(courseBase, courseBaseDto);

        if (courseMarket != null) {
            BeanUtils.copyProperties(courseMarket, courseBaseDto);
        }
        // 查找分类名称
        CourseCategory mtCategory = courseCategoryMapper.selectById(courseBase.getMt());
        if (mtCategory != null) {
            courseBaseDto.setMtName(mtCategory.getName());
        }
        CourseCategory stCategory = courseCategoryMapper.selectById(courseBase.getSt());
        if (stCategory != null) {
            courseBaseDto.setMtName(stCategory.getName());
        }

        return courseBaseDto;
    }

    private int saveCourseMarketInfo(CourseMarket courseMarketNew) {
        String charge = courseMarketNew.getCharge();
        if (charge == null) {
            LearningException.cast("收费规则不能为空");
        }
        if (charge.equals("201001")) {
            Float price = courseMarketNew.getPrice();
            if (price == null || price.floatValue() <= 0) {
                LearningException.cast("收费金额不能为空，且必须>0");
            }
        }

        Long courseId = courseMarketNew.getId();

        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        if (courseMarket == null) {
            int insert = courseMarketMapper.insert(courseMarketNew);
            return insert;
        } else {
            BeanUtils.copyProperties(courseMarketNew, courseMarket);
            courseMarket.setId(courseId);
            int i = courseMarketMapper.updateById(courseMarket);
            return i;
        }
    }
}
