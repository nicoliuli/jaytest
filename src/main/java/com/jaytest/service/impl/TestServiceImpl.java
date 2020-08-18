package com.jaytest.service.impl;

import com.alibaba.fastjson.JSON;
import com.jaytest.dao.TestMapper;
import com.jaytest.model.ProjectRequest;
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
    public void insertTiRequest(List<ProjectRequest> list) {
        log.info("TestServiceImpl insertTiRequest {}", JSON.toJSONString(list));

        for (ProjectRequest d : list) {
            testMapper.insertTiRequest(d);
        }
    }

    @Override
    public List<ProjectRequest> selProject(ProjectRequest projectRequest){

        List<ProjectRequest> list= testMapper.selProject(projectRequest); //传入sql参数
        log.info("aaaaaa={},{}",JSON.toJSONString(projectRequest),JSON.toJSONString(list));

        for (ProjectRequest vl : list) {
            if ("工商联222活动房项目".equals(vl.getPROJ_NAME())) {
                vl.setOGN_CODE("2");
            }
        }
        //业务逻辑
        return list;
    }

    @Override
    public List<ProjectRequest> selpidProject(ProjectRequest projectRequest){
        List<ProjectRequest> list= testMapper.selpidProject(projectRequest); //传入sql参数

        return list;
    }


    @Autowired
    private TestMapper testMapper;


}
