package com.shizheng.teachermanagesystem.controller;

import com.shizheng.teachermanagesystem.service.TeacherService;
import com.shizheng.teachermanagesystem.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author shizheng
 */
@Api("教师信息接口")
@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {


    @Resource
    private TeacherService teacherService;

    @Resource
    private RedisUtils redisUtils;
    /**
     * 测试一下
     * @return
     */
    @ApiOperation("测试一下")
    @RequestMapping(value = "/helloWard", method = RequestMethod.GET)
    public String deleteTeacher() {
        String key = "test2";
        Object obj = redisUtils.get(key);
        if (Objects.nonNull(obj)) {
            String value = obj.toString();
            if (StringUtils.isNotEmpty(value)) {
                return value;
            }
        }
        redisUtils.set(key, "我是时政",10, TimeUnit.SECONDS);
        return "helloWard";
    }

    /**
     * 获取教师信息
     * @param id
     * @return
     */
    @ApiOperation("查询某个教师详细")
    @RequestMapping(value = "/getTeacherInfo/{id}",method = RequestMethod.GET)
    public Object getInfo(@PathVariable String id){
        return teacherService.getTeacherInfo(id);
    }


    /**
     * 获取教师信息
     * @param id
     * @return
     */
    @ApiOperation("查询某个教师详细")
    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.GET)
    public Object deleteTeacher(@PathVariable String id) {
        return "你好";
    }
}
