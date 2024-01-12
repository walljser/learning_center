package com.yg.learning.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yg.learning.content.model.dto.CourseCategoryTreeDto;
import com.yg.learning.content.model.pojo.CourseCategory;

import java.util.List;

public interface CourseCategoryService extends IService<CourseCategory> {
    List<CourseCategoryTreeDto> queryAllTreeNodes(String id);
}
