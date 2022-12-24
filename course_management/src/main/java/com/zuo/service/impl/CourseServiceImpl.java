package com.zuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zuo.common.R;
import com.zuo.entity.Course;
import com.zuo.entity.request.CourseRequest;
import com.zuo.entity.request.CourseRequestplus;
import com.zuo.mapper.CourseMapper;
import com.zuo.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zuo.vo.DetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-12-24
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    /***
     * 删除课程
     */
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public R removeCourse(CourseRequest courseRequest) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("course_id",courseRequest.getCourseId());
        int delete = courseMapper.delete(courseQueryWrapper);
        if(delete > 0)return R.success("删除成功");
        else return R.error("删除失败");
    }

    /**
     * 添加课程
     * @param courseRequest
     * @return
     */
    @Override
    public R addCourse(CourseRequestplus courseRequest) {
        /********课程重名或者教室相同提示错误************/
        String coursename = courseRequest.getCourseName();
        String classroom = courseRequest.getClassroom();
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Course> courseQueryWrapper1 = new QueryWrapper<>();
        courseQueryWrapper.eq("course_name",coursename);
        courseQueryWrapper1.eq("classroom",classroom);
        List<Course> course1 = courseMapper.selectList(courseQueryWrapper);
        List<Course> course2 = courseMapper.selectList(courseQueryWrapper1);
        if(course1.size() > 0) return R.error("课程名称冲突，请重新输入");
        if(course2.size() > 0) return R.error("教室冲突，请重新选择");
        /********字数判断********/

        String coursedescribe = courseRequest.getCourseDescribe();
        if(coursename.length() > 50)return R.error("课程名称超过50！！！");
        if(coursedescribe.length() > 200)return R.error("课程描述超过200！！！");

        /******人数判断************/
        Integer people = Integer.valueOf(courseRequest.getOptionalNumber());
        if(people < 1 || people > 150)return R.error("注意！人数需要1~150的限制");

        /******时间格式校验*********/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date =dateFormat.parse(courseRequest.getLessonTime());
            boolean equals = courseRequest.getLessonTime().equals(dateFormat.format(date));
            if(!equals)return R.error("时间格式错误，请严格遵循yyyy-MM-dd格式");

        } catch (ParseException e) {
            e.printStackTrace();
            return R.error("格式错误");
        }
        /************************/

        /******时间毫秒转换*********/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;
        try {
            time = simpleDateFormat.parse(courseRequest.getLessonTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return R.error("时间转换失败");
        }
        /************************/

        /********数据存储准备********/
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setClassroom(courseRequest.getClassroom());
        course.setModeDelivery(courseRequest.getModeDelivery());
        course.setOptionalNumber(courseRequest.getOptionalNumber());
        course.setLessonTime(time);
        course.setCourseDescribe(courseRequest.getCourseDescribe());
        /************************/
        /********数据存储与结果返回********/
        String[] s = courseRequest.getOptionalMajor();
        int save = 0;
        for(String t : s)
        {
            if(t == null)break;
            Course temp = course;
            temp.setOptionalMajor(t);
            int res = courseMapper.insert(temp);
            if(res == 1)save++;
        }

        if(save > 0) return R.success("存储成功"+save+"个专业的数据");
        else return R.error("存储失败");
        /*************************/
    }

    /**
     * 更新课程
     * @param courseRequest
     * @return
     */
    @Override
    public R courseUpdate(CourseRequest courseRequest) {
        /******字数判断************/
        String coursename = courseRequest.getCourseName();
        String coursedescribe = courseRequest.getCourseDescribe();
        if(coursename.length() > 50)return R.error("课程名称超过50！！！");
        if(coursedescribe.length() > 200)return R.error("课程描述超过200！！！");

        /******人数判断************/
        Integer people = Integer.valueOf(courseRequest.getOptionalNumber());
        if(people < 1 || people > 150)return R.error("注意！人数需要1~150的限制");

        /******时间格式校验*********/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date =dateFormat.parse(courseRequest.getLessonTime());
            boolean equals = courseRequest.getLessonTime().equals(dateFormat.format(date));
            if(!equals)return R.error("时间格式错误，请严格遵循yyyy-MM-dd格式");

        } catch (ParseException e) {
            e.printStackTrace();
            return R.error("格式错误");
        }
        /************************/

        /******时间毫秒转换*********/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;
        try {
            time = simpleDateFormat.parse(courseRequest.getLessonTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return R.error("时间转换失败");
        }
        /************************/

        /********数据存储准备********/
        Course course = new Course();
        course.setCourseId(courseRequest.getCourseId());
        course.setCourseName(courseRequest.getCourseName());
        course.setClassroom(courseRequest.getClassroom());
        course.setModeDelivery(courseRequest.getModeDelivery());
        course.setOptionalMajor(courseRequest.getOptionalMajor());
        course.setOptionalNumber(courseRequest.getOptionalNumber());
        course.setLessonTime(time);
        course.setCourseDescribe(courseRequest.getCourseDescribe());
        /************************/
        int num = courseMapper.update(course,new QueryWrapper<Course>().eq("course_id",courseRequest.getCourseId()));
        if(num > 0)return R.success("更新成功");
        else return R.error("更新失败");
    }

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    @Override
    public R getDetailById(Integer id) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("course_id",id);
        Course course = courseMapper.selectOne(courseQueryWrapper);
        //健壮性判断
        if(course==null)return R.error("查询不到课程");
        Long time = course.getLessonTime();
        Date date = new Date();
        date.setTime(time);
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
        String transformDate = formatter.format(date);
        /*******数据设置************/
        DetailVo detailVo = new DetailVo();
        detailVo.setCourseId(course.getCourseId());
        detailVo.setCourseName(course.getCourseName());
        detailVo.setClassroom(course.getClassroom());
        detailVo.setOptionalMajor(course.getOptionalMajor());
        detailVo.setLessonTime(transformDate);
        detailVo.setModeDelivery(course.getModeDelivery());
        detailVo.setOptionalNumber(course.getOptionalNumber());
        detailVo.setCourseDescribe(course.getCourseDescribe());
        return R.success("查询成功",detailVo);
    }
}
