package com.jaytest.controller;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.RESUtils;
import com.jaytest.model.TiRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {



    @PostMapping(value = "/ProjectMess1")
    @ResponseBody
    public String ProjectMess(String response,String key) throws Exception {
        System.out.println(response);
        System.out.println(key);

        RESUtils resUtils = new RESUtils();
        String rmdmess = resUtils.desDecrypt(response, key);
        // json字符串转成java对象
        TiRequest tiRequest = JSON.parseObject(rmdmess, TiRequest.class);
        log.info("解密后::" + rmdmess);
        log.info("json转成对象：{}",tiRequest);
       return "aaa";
    }

}
