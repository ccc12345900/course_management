package com.zuo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zuo.common.R;
import com.zuo.entity.Course;
import com.zuo.entity.request.CourseRequest;
import com.zuo.entity.request.CourseRequestplus;
import com.zuo.entity.request.DetailRequest;
import com.zuo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-12-24
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public R courseAdd(@RequestBody CourseRequestplus courseRequest)
    {
        String[] num = courseRequest.getOptionalMajor();
        if(num[0] == null)return R.error("请至少选择一个专业!!!");
        String[] newData = new String[num.length];
        for(int i = 0;i < num.length;i++)
        {
            if(num[i]!=null) {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");

                Matcher m = p.matcher(num[i]);

                String dest = m.replaceAll("");
                newData[i] = dest;
            }
        }
        courseRequest.setOptionalMajor(newData);
        return courseService.addCourse(courseRequest);
    }

    @PostMapping("/delete")
    public R courseDelete(@RequestBody CourseRequest courseRequest)
    {
        return courseService.removeCourse(courseRequest);
    }


    @PostMapping("/update")
    public R courseUpdate(@RequestBody CourseRequest courseRequest)
    {
        return courseService.courseUpdate(courseRequest);
    }

    @GetMapping("/list")
    public R courseList(){
        return R.success("所有课程",courseService.list());
    }

    @PostMapping("/listById")
    public R courseListById(@RequestBody DetailRequest detailRequest)
    {
        return courseService.getDetailById(detailRequest.getId());
    }
}

