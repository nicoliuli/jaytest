package com.jaytest.controller;

import com.jaytest.model.Demo;
import com.jaytest.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
public class DemoController {
    @GetMapping("/getUser")
    public String getUser() {
        return "getUser:" + "8080";
    }

//第二步，调用
    @GetMapping("/addDemo")
    public String addDemo(Demo demo){

        System.out.println(demo.getSex());
        System.out.println(demo.getTel());
        System.out.println(demo.getId());
        demo.setDate(new Date());

//        Demo demo = new Demo();
//        demo.setId(1);
//        demo.setDate(new Date());
//        demo.setName("aaa");
//        demo.setTel("123");
//        demo.setSex(request.getParameter("sex"));

        demoService.addDemo(demo);
        return "success";
    }

    @GetMapping("/updateDemo")
    public String updateDemo(Demo demo){

        System.out.println(demo.getSex());
        System.out.println(demo.getTel());
        System.out.println(demo.getId());
        demo.setDate(new Date());


        Integer integer = demoService.updateDemo(demo);
        return "success:"+integer;
    }

    @GetMapping("/queryDemo")
    public List<Demo> queryDemo(Demo demo){

        System.out.println(demo.getSex());
        System.out.println(demo.getTel());
        System.out.println(demo.getId());
        demo.setDate(new Date());

        log.info("！！！哈哈哈哈哈哈哈哈哈在重中之重重中之重");

        List<Demo> demos = demoService.queryDemo(demo);
        return  demos;
    }

    @GetMapping("/delDemo")
    public Demo delDemo(Integer id){
        System.out.println(id);
        Demo demo = demoService.delDemo(id);
        return demo;
    }

    @GetMapping("/getDemo")
    public Demo getDemo(Integer id){
        Demo demo = demoService.getDemo(id);
        return  demo;
    }


    public void test(){
        List<Integer>  list1 = new ArrayList<>() ;
        List<Integer>  list2 = new ArrayList<>() ;
        list1.add(1);
        list2.add(2);
        list1.addAll(list2);

        // 不能有重复元素
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);set1.add(1);

        // map
        Map<String,Integer> map = new HashMap<>();
        map.put("key1",1);

    }

    @GetMapping("test1")
    public Integer test1(Demo demo){
        return 0;
    }



//第一步 引用
 //   @Resource(name="demoService")
    @Autowired
    private DemoService demoService; // new DemoServiceImpl():


}
