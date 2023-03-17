package com.shizheng.teachermanagesystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shizheng
 */
@Api("教师信息接口")
@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {


    /**
     * 获取教师信息
     * @param id
     * @return
     */
    @ApiOperation("查询某个教师详细")
    @RequestMapping(value = "/getTeacherInfo",method = RequestMethod.GET)
    public Object getInfo(String id){
        return "你好";
    }
}
