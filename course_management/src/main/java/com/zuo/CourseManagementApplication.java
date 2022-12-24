package com.zuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zuo.mapper")
public class CourseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementApplication.class, args);
    }

}
