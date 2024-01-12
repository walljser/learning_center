package com.yg.learning.content.model.dto;

import com.yg.learning.content.model.dto.CreateCourseDto;
import lombok.Data;

@Data
public class UpdateCourseDto extends CreateCourseDto {
    private Long id;
}
