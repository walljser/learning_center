package com.yg.learning.content.web;

import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.service.TeachPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeachPlanController {
    @Autowired
    private TeachPlanService teachPlanService;

    @GetMapping("/course/{courseId}/teachplan/tree-nodes")
    public List<TeachplanDto> queryTreeNodes(@PathVariable("courseId") Long courseId) {
        return teachPlanService.queryTreeNodesByCourseId(courseId);
    }
}
