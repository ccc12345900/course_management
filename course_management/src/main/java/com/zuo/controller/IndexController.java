package com.zuo.controller;

import com.zuo.common.R;
import com.zuo.entity.Major;
import com.zuo.service.ClassroomService;
import com.zuo.service.CourseService;
import com.zuo.service.MajorService;
import com.zuo.vo.MajorCheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 橙宝cc
 * @date 2022/12/24 - 13:44
 */
@Controller
public class IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private MajorService majorService;


    @RequestMapping("/todoList")
    public String todoList(Model model)
    {
        model.addAttribute("course",courseService.list());
        return "todo_list";
    }

    @GetMapping("/toastr")
    public String toastr(Model model)
    {
        model.addAttribute("classroom",classroomService.list());
        model.addAttribute("major",majorService.list());
        return "toastr";
    }

    @GetMapping("/update/{id}")
    public String updateById(@PathVariable("id") Integer id,Model model)
    {
        R detailById = courseService.getDetailById(id);
        model.addAttribute("course",detailById.getData());
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id,Model model)
    {
        R detailById = courseService.getDetailById(id);
        model.addAttribute("course",detailById.getData());
        return "delete";
    }

    @GetMapping("/detail/{id}")
    public String detailById(@PathVariable("id") Integer id,Model model)
    {
        R detailById = courseService.getDetailById(id);
        model.addAttribute("course",detailById.getData());
        return "detail";
    }
}
