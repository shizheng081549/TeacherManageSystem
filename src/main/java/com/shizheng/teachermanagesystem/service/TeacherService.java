package com.shizheng.teachermanagesystem.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author shizheng
 */
@Slf4j
@Service
public class TeacherService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Object getTeacherInfo(String id) {
        String value = redisTemplate.opsForValue().get(id);
        if (StringUtils.isEmpty(value)) {
            value = "时政是个大帅哥";
            redisTemplate.opsForValue().set(id, value, 30, TimeUnit.SECONDS);
        }
        return value;
    }
}
