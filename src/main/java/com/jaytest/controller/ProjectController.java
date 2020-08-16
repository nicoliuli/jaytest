package com.jaytest.controller;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.ProjectResponse;
import com.jaytest.model.RESUtils;
import com.jaytest.model.TiRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ProjectController {

//    @Autowired
//    private RESUtils resUtils; // new DemoServiceImpl():

    @Override
    public String toString() {
        return "ProjectController{}";
    }

    //    @PostMapping(value = "/ProjectMess", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
//    @ResponseBody
//    public TiResponse ProjectMess(@RequestBody TiRequest tiRequest){
//        TiResponse tiResponse=new TiResponse();
//        ProjectResponse ROW_INFO=new ProjectResponse(); //数组
//        ProjectResponse o=new ProjectResponse();
//        o.setData("数据上报成功!");
//        o.setCode("000");
//
////        ROW_INFO.add(o);
//        log.info("xml！！！ROW_INFO::" + ROW_INFO);
//        tiResponse.setDATA(o); //赋值
//        log.info("xml！！！请求::" + tiRequest);
//        log.info("xml！！！回复的返回值::" + o);
//        return tiResponse;
//    }

    @PostMapping(value = "/ProjectMess", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ProjectResponse ProjectMess(@RequestBody TiRequest tiRequest) throws Exception {
        ProjectResponse o=new ProjectResponse();
        o.setData("数据上报成功!");
        o.setCode("000");

//        ROW_INFO.add(o);
//        log.info("xml！！！ROW_INFO::" + ROW_INFO);
//        0.setDATA(o); //赋值
        log.info("xml！！！请求::" + tiRequest);
        log.info("xml！！！回复的返回值::" + o);

        String json = JSON.toJSONString(tiRequest);
        log.info("json={}",json,o);

        RESUtils resUtils = new RESUtils();
        String mdmess = resUtils.desEncrypt(json, "12345678");
        log.info("加密后::" + mdmess);

        String rmdmess = resUtils.desDecrypt(mdmess, "12345678");
        log.info("解密后::" + rmdmess);
        return o;
    }

    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

}
