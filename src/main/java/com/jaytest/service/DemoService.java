package com.jaytest.service;

import com.jaytest.model.Demo;

import java.util.List;

/**
 * 接口
 */
public interface DemoService {
    public void addDemo(Demo demo);

    public Integer updateDemo(Demo demo);

    public List<Demo> queryDemo(Demo demo);

    public Demo getDemo(Integer id);

    public Demo delDemo(Integer id);

}
