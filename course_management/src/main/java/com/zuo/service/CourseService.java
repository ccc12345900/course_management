package com.zuo.service;

import com.zuo.common.R;
import com.zuo.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zuo.entity.request.CourseRequest;
import com.zuo.entity.request.CourseRequestplus;
import com.zuo.entity.request.DetailRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-12-24
 */
public interface CourseService extends IService<Course> {
    R removeCourse(CourseRequest courseRequest);
    R addCourse(CourseRequestplus courseRequest);

    R courseUpdate(CourseRequest courseRequest);

    R getDetailById(Integer id);
}
