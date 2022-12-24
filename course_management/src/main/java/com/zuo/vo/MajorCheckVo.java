package com.zuo.vo;

import com.zuo.entity.Major;
import lombok.Data;

import java.util.List;

@Data
public class MajorCheckVo {
    private List<Major> majors;

    private List<Boolean> choices;
}