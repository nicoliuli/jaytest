package com.jaytest.service;

import com.jaytest.model.User;

/**
 * 接口
 */
public interface RedisService {


    public void set();

    public User getUserById(Integer id);
}
