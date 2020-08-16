package com.jaytest.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 */
@Slf4j
// 这个注解，表示这个service被spring容器管理
@Component
public class ScheduleServiceImpl {


    /*static {
        load();
    }
    private static void load(){
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时器执行。。。");

            }
        }, 1, 2, TimeUnit.SECONDS);
    }*/



    //每隔1秒执行一次
    @Scheduled(fixedRate = 1000)
    public void aaa() {
        System.out.println("每1s执行一次");
    }

    //每天16：42：30执行
    @Scheduled(cron = "30 42 16 ? * *")
    public void bbb() {
        System.out.println("bbbb");
    }

}
