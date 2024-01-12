package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yg.learning.content.mapper.TeachplanMapper;
import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.model.pojo.Teachplan;
import com.yg.learning.content.service.TeachPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeachPlanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan> implements TeachPlanService {
    @Autowired
    private TeachplanMapper teachplanMapper;

    @Override
    public List<TeachplanDto> queryTreeNodesByCourseId(Long courseId) {
        return teachplanMapper.selectTeachPlanTreeNodesByCourseId(courseId);
    }
}
