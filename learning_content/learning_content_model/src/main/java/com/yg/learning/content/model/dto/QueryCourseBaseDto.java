package com.yg.learning.content.model.dto;

import lombok.Data;

@Data
public class QueryCourseBaseDto {
        //审核状态
        private String auditStatus;
        //课程名称
        private String courseName;
        //发布状态
        private String publishStatus;
}
