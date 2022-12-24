package com.zuo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author 橙宝cc
 * @date 2022/12/24 - 17:11
 */
@Data
public class DetailVo {
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
    private String optionalMajor;

    /**
     * 授课方式
     */
    private String modeDelivery;

    private String courseDescribe;

}
