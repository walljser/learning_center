package com.yg.learning.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yg.learning.base.model.PageParams;
import com.yg.learning.base.model.PageResult;
import com.yg.learning.content.mapper.CourseCategoryMapper;
import com.yg.learning.content.model.dto.CourseCategoryTreeDto;
import com.yg.learning.content.model.pojo.CourseCategory;
import com.yg.learning.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory> implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> queryAllTreeNodes(String id) {
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);

        // 找到每个节点的子节点，最终封装成List<CourseCategoryTreeDto>
        // 先将list转成map，key就是结点的id，value就是CourseCategoryTreeDto对象，目的就是为了方便从map获取结点,filter(item->!id.equals(item.getId()))把根结点排除
        Map<String, CourseCategoryTreeDto> mapTemp = categoryTreeDtos.stream().filter(item -> !id.equals(item.getId()))
                        .collect(Collectors.toMap(CourseCategoryTreeDto::getId, value -> value, (key1, key2) -> key1));

        List<CourseCategoryTreeDto> categoryTreeDtoList = new ArrayList<>();
        categoryTreeDtos.stream().filter(item -> !id.equals(item.getId())).forEach(item -> {
            if (item.getParentid().equals(id)) {
                categoryTreeDtoList.add(item);
            }
            CourseCategoryTreeDto parent = mapTemp.get(item.getParentid());

            if (parent != null) {
                if (parent.getChildrenTreeNodes() == null) {
                    parent.setChildrenTreeNodes(new ArrayList<>());
                }
                parent.getChildrenTreeNodes().add(item);
            }
        });

        return categoryTreeDtoList;
    }
}
