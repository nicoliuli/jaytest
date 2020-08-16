package com.jaytest.controller;

import com.jaytest.model.Demo;
import com.jaytest.model.Ji;
import com.jaytest.service.DemoService;
import com.jaytest.service.JiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class JiController {

    //第一步 引用
    //   @Resource(name="demoService")
    @Autowired
    private JiService jiService; // new DemoServiceImpl():

    @GetMapping("/JigetDemo")
    public Ji JigetDemo(Integer id){

        System.out.println("JiController1>>>" + id);
        Ji demo = jiService.JigetDemo(id);
        return  demo;
    }

    @GetMapping("/querey2")
    public List<Ji> querida(Ji ji){

        List<Ji> ss = jiService.queryDemo(ji);
        return ss;
    }

    @GetMapping("/sdata")
    public void queryDemo(List data){

        log.info("！！！哈哈哈zzzzzzzhahhah哈哈哈哈哈哈哈::" + data);
//        return  data;
    }
}
