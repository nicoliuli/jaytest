package com.jaytest.service.impl;

import com.alibaba.fastjson.JSON;
import com.jaytest.dao.TestMapper;
import com.jaytest.model.ProjectRequest;
import com.jaytest.model.TiRequest;
import com.jaytest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现类
 */
@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {

    // 写业务逻辑
    @Override
    public void insertTiRequest(TiRequest tiRequest) {
        log.info("TestServiceImpl insertTiRequest {}", JSON.toJSONString(tiRequest));
        List<ProjectRequest> data = tiRequest.getDATA();

        for (ProjectRequest d : data) {
            testMapper.insertTiRequest(d);
        }
    }



    @Autowired
    private TestMapper testMapper;


}
