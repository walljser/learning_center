package com.yg.learning.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yg.learning.content.model.dto.CourseCategoryTreeDto;
import com.yg.learning.content.model.pojo.CourseCategory;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author yg
 */
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {
    List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
