package com.yg.learning.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.model.pojo.Teachplan;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author yg
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    List<TeachplanDto> selectTeachPlanTreeNodesByCourseId(Long id);
}
