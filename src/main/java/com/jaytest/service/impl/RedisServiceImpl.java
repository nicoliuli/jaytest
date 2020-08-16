package com.jaytest.service.impl;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.User;
import com.jaytest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 实现类
 */
@Service("redisService")
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public void set() {
        User u = new User(1, "张三");
        redisTemplate.opsForValue().set("user" + u.getId(), JSON.toJSONString(u));
        User u2 = new User(2, "李四");
        redisTemplate.opsForValue().set("user" + 2, JSON.toJSONString(u2));
    }

    @Override
    public User getUserById(Integer id) {
        String str = (String) redisTemplate.opsForValue().get("user" + id);

        return JSON.parseObject(str,User.class);
    }
}
