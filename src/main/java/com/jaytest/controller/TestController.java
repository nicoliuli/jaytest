package com.jaytest.controller;

import com.alibaba.fastjson.JSON;
import com.jaytest.model.*;
import com.jaytest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
        String rmdmess = resUtils.desDecrypt(requestString, key); //解密后的json字符串
        // json字符串转成java对象
        TiRequest tiRequest = JSON.parseObject(rmdmess, TiRequest.class);
        log.info("解密后::" + rmdmess);
        // TODO: 2020/8/18 这样打印日志不规范,应该是这样 log.info("json转成对象：{}",JSON.toJSONString(tiRequest.getDATA()));
        log.info("json转成对象：{}",tiRequest.getDATA());



        //第一种方式
        List<ProjectRequest> datas = tiRequest.getDATA(); //json转成对象
        for (ProjectRequest d : datas) {
//            log.info("查看 |我是结果值getPROJ_ID|{}",d.getPROJ_ID()); // 得到 每个对象中的属性值
            List<ProjectRequest> Proj= selectid(d.getPROJ_ID());
//            log.info("查看 |遍历后的结果值|PROJ_ID={}|{}",d.getPROJ_ID(),Proj);
//            log.info("查看 |遍历后的size值|siz={}|{}",d.getPROJ_ID(),Proj.size());
            if( Proj.size() == 0 ){
                //zj：：把结果d传入insertTiRequest 或者一个新的存库方法，d转换成什么格式？之后在传入？
//                testService.insertTiRequest(ti);
                // TODO: 2020/8/18 这样写
                List<ProjectRequest> reqList = new ArrayList<>();
                reqList.add(d);
                testService.insertTiRequest(reqList);
            }
        }



//        //第二种方式
//        JSONObject des = JSONArray.parseObject(rmdmess);
//        log.info("查看 des::{}",des);
//        log.info("查看 des.size::{}",des.size());
//        log.info("查看 des:data:{}",des.get("data"));
//        JSONArray datas = (JSONArray) des.get("data");
//        log.info("查看 des:data:{}",getType(datas));
//        for(int i=0;i<datas.size();i++){
//            JSONObject job = datas.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//            log.info("查看 |我是结果值|{}",job.get("proj_id")); // 得到 每个对象中的属性值
//        }




//        testService.insertTiRequest(tiRequest);

        TiResponse resp = new TiResponse();
        ProjectResponse data = new ProjectResponse();
        data.setCode("000");
        data.setData("数据上报成功！");
        resp.setDATA(data);
       return resp;
    }

    // 请求key=value，响应xml  -- 添加全部数据
    // TODO: 2020/8/18 接口命名不规范，首字母要小写，严格禁止大写 projectAllMess
    @PostMapping(value = "/ProjectAllMess",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TiResponse projectAllMess(String requestString, String key) throws Exception {
        // TODO: 2020/8/18 项目中严格禁止使用 System.out.printl，用log
        System.out.println(requestString);
        System.out.println(key);

        RESUtils resUtils = new RESUtils();
        String rmdmess = resUtils.desDecrypt(requestString, key); //解密后的json字符串
        // json字符串转成java对象
        TiRequest tiRequest = JSON.parseObject(rmdmess, TiRequest.class);
        log.info("解密后::{}",rmdmess);
        log.info("json转成对象：{}",tiRequest.getDATA());

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

    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

    //通过PROJ_ID查询结果值
    public List<ProjectRequest> selectid(String PROJ_ID){ // TODO: 2020/8/18  PROJ_ID命名不规范，应该是projId

        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setPROJ_ID(PROJ_ID);
        List<ProjectRequest> ll = testService.selpidProject(projectRequest);
        return ll;
    }

}
