package com.jaytest.controller;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.ProjectResponse;
import com.jaytest.model.RESUtils;
import com.jaytest.model.TiRequest;
import com.jaytest.model.TiResponse;
import com.jaytest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        int ret = testService.insertTiRequest(tiRequest);

        TiResponse resp = new TiResponse();
        ProjectResponse data = new ProjectResponse();
        if(ret >0){
            data.setCode("000");
            data.setData("数据上报成功！");
        }else{
            data.setCode("1111");
            data.setData("数据上报失败！");
        }

        resp.setDATA(data);
       return resp;
    }

}
