package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beust.jcommander.internal.Lists;
import com.yg.learning.content.mapper.TeachplanMapper;
import com.yg.learning.content.model.dto.SaveTeachplanDto;
import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.model.pojo.Teachplan;
import com.yg.learning.content.service.TeachPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TeachPlanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan> implements TeachPlanService {
    @Autowired
    private TeachplanMapper teachplanMapper;

    @Override
    public List<TeachplanDto> queryTreeNodesByCourseId(Long courseId) {
//        LambdaQueryWrapper<Teachplan> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(Teachplan::getCourseId, courseId);
//        int count = teachplanMapper.selectCount(lqw);
//        if (count == 1) {
//            Teachplan teachplan = teachplanMapper.selectOne(lqw);
//
//            List<TeachplanDto> list = new ArrayList<>();
//            TeachplanDto teachplanDto = new TeachplanDto();
//            BeanUtils.copyProperties(teachplan, teachplanDto);
//            list.add(teachplanDto);
//            return list;
//        }
//        return teachplanMapper.selectTeachPlanTreeNodesByCourseId(courseId);
        List<TeachplanDto> teachplans = teachplanMapper.selectTeachplanByCourseId(courseId);
        List<TeachplanDto> list = list2Tree(teachplans);
        return list;
    }

    private List<TeachplanDto> list2Tree(List<TeachplanDto> cityEntities) {
        List<TeachplanDto> resultTeachplanDtos = new ArrayList<>();
        for (TeachplanDto teachplanDto: cityEntities) {
            if(0 == teachplanDto.getParentid()) { //根节点、顶级节点，直接放入最终返回结果的List
                resultTeachplanDtos.add(teachplanDto);
            }
            for (TeachplanDto curTeachplanDto: cityEntities) { //根据当前city找它的子节点
                if(teachplanDto.getId().equals(curTeachplanDto.getParentid())) {
                    if(teachplanDto.getTeachPlanTreeNodes() == null) { //还没有任何子节点，new一个空的放进去
                        teachplanDto.setTeachPlanTreeNodes(new ArrayList<>());
                    }
                    teachplanDto.getTeachPlanTreeNodes().add(curTeachplanDto);
                }
            }
        }
        return resultTeachplanDtos;
    }

    private Integer getTeachplanCount(Long courseId, Long parentId) {
        LambdaQueryWrapper<Teachplan> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Teachplan::getCourseId, courseId);
        lqw.eq(Teachplan::getParentid, parentId);
        Integer count = teachplanMapper.selectCount(lqw);
        return count;
    }

    @Override
    public void saveTeachplanInfo(SaveTeachplanDto saveTeachplanDto) {
        Long teachplanId = saveTeachplanDto.getId();


        if (teachplanId == null) {
            Teachplan teachplanNew = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto, teachplanNew);

            Integer teachplanCount = getTeachplanCount(teachplanNew.getCourseId(), teachplanNew.getParentid());
            teachplanNew.setOrderby(teachplanCount);
            teachplanMapper.insert(teachplanNew);
        } else {
            Teachplan teachplanNew = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto, teachplanNew);
            teachplanMapper.updateById(teachplanNew);
        }
    }
}
