package com.jaytest.controller;

import com.jaytest.model.User;
import com.jaytest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class RedisController {





    @Autowired
    private RedisService redisService;

    @PostMapping("/getUser")
    @ResponseBody
    public User getUser(Integer id){

         User u = redisService.getUserById(id);
        return u;
    }

    @PostMapping("/setUser")
    @ResponseBody
    public String setUser(){
        redisService.set();
        return "aaa";
    }

}
