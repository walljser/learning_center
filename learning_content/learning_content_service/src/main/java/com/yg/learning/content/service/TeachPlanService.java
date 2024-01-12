package com.yg.learning.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yg.learning.content.model.dto.SaveTeachplanDto;
import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.model.pojo.Teachplan;

import java.util.List;

public interface TeachPlanService extends IService<Teachplan> {
    List<TeachplanDto> queryTreeNodesByCourseId(Long courseId);

    void saveTeachplanInfo(SaveTeachplanDto saveTeachplanDto);
}
