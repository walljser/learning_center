package com.yg.learning.content.model.dto;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateCourseDto {

    @NotEmpty(message = "课程名称不能为空")
    private String name;

    @NotEmpty(message = "适用人群不能为空")
    private String users;

    private String tags;

    @NotEmpty(message = "课程分类不能为空")
    private String mt;

    @NotEmpty(message = "课程分类不能为空")
    private String st;

    @NotEmpty(message = "课程等级不能为空")
    private String grade;

    @NotEmpty(message = "教学模式不能为空")
    private String teachmode;

    private String description;

    private String pic;

    @NotEmpty(message = "收费规则不能为空")
    private String charge;

    private Float price;
    private Float originalPrice;

    private String qq;

    private String wechat;
    private String phone;

    private Integer validDays;
}
