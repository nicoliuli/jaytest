package com.jaytest.controller;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.*;
import com.jaytest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class TestController {


    @Autowired
    private TestService testService;

    // 请求key=value，响应xml
    @PostMapping(value = "/ProjectMess1",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TiResponse ProjectMess(String requestString, String key) throws Exception {
        System.out.println(requestString);
        System.out.println(key);

        RESUtils resUtils = new RESUtils();
        String rmdmess = resUtils.desDecrypt(requestString, key);
        // json字符串转成java对象
        TiRequest tiRequest = JSON.parseObject(rmdmess, TiRequest.class);
        log.info("解密后::" + rmdmess);
        log.info("json转成对象：{}",tiRequest);

        testService.insertTiRequest(tiRequest);

        TiResponse resp = new TiResponse();
        ProjectResponse data = new ProjectResponse();
        data.setCode("000");
        data.setData("数据上报成功！");
        resp.setDATA(data);
       return resp;
    }

    @PostMapping("/SelProject")
    @ResponseBody
    public List<ProjectRequest> select(String aaa){

         ProjectRequest projectRequest = new ProjectRequest();
         projectRequest.setPROJ_NAME(aaa);
        List<ProjectRequest> ll = testService.selProject(projectRequest);
        return ll;
    }

}
