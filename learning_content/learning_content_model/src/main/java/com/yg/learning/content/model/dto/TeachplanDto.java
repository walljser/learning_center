package com.yg.learning.content.model.dto;

import com.yg.learning.content.model.pojo.Teachplan;
import com.yg.learning.content.model.pojo.TeachplanMedia;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class TeachplanDto extends Teachplan {
    private TeachplanMedia teachplanMedia;

    private List<TeachplanDto> teachPlanTreeNodes;
}
