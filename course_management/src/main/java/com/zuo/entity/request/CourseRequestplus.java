package com.zuo.entity.request;

import lombok.Data;

/**
 * @author 橙宝cc
 * @date 2022/12/24 - 10:21
 */
@Data
public class CourseRequestplus {
    /**
     * 课程号
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 授课时间
     */
    private String lessonTime;

    /**
     * 可选人数
     */
    private Integer optionalNumber;

    /**
     * 教室
     */
    private String classroom;

    /**
     * 可选专业
     */
    private String[] optionalMajor;

    /**
     * 授课方式
     */
    private String modeDelivery;

    private String courseDescribe;
}
