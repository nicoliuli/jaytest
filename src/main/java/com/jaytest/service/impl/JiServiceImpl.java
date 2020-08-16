package com.jaytest.service.impl;

import com.jaytest.dao.JiMapper;
import com.jaytest.model.Demo;
import com.jaytest.model.Ji;
import com.jaytest.service.JiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("JiService")
public class JiServiceImpl implements JiService {
    @Autowired
    private JiMapper jiMapper;

    @Override
    public Ji JigetDemo(Integer id) {

        System.out.println("JiServiceImpl2>>>" + id);
        return jiMapper.JigetDemo(id);
    }

    @Override
    public List<Ji> queryDemo(Ji ji) {
        return jiMapper.queryDemo(ji);
    }
}
