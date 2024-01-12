package com.yg.learning.content.web;

import com.yg.learning.content.model.dto.SaveTeachplanDto;
import com.yg.learning.content.model.dto.TeachplanDto;
import com.yg.learning.content.service.TeachPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeachPlanController {
    @Autowired
    private TeachPlanService teachPlanService;

    @PostMapping("/teachplan")
    public void createTeachPlan(@RequestBody SaveTeachplanDto saveTeachplanDto) {
        teachPlanService.saveTeachplanInfo(saveTeachplanDto);
    }

    @GetMapping("/course/{courseId}/teachplan/tree-nodes")
    public List<TeachplanDto> queryTreeNodes(@PathVariable("courseId") Long courseId) {
        return teachPlanService.queryTreeNodesByCourseId(courseId);
    }
}
