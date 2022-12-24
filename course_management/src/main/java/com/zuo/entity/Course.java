package com.zuo.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2022-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Course implements Serializable {

    private static final long serialVersionUID=1L;

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
    private Long lessonTime;

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
    @TableField("Mode_delivery")
    private String modeDelivery;

    private String courseDescribe;

}
