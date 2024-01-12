package com.yg.learning.content.model.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ToString
@Data
public class SaveTeachplanDto {
    private Long id;
    @NotBlank(message = "课程不能为空")
    private Long courseId;
    @NotBlank(message = "父id不能为空")
    private Long parentid;
    @NotBlank(message = "层级不能为空")
    private Integer grade;
    @NotBlank(message = "名称不能为空")
    private String pname;
    private String mediaType;
    private Long CoursePubId;
    private Integer status;
    private String isPreview;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
