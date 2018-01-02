package com.xjd.web.MainTest;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Administrator on 2018/1/2.
 */
public class TaskTest {
    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("定时任务进行中.."+System.currentTimeMillis());
    }
}
