package com.liumt.springbootdemo.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 11:34
 * @description：监听器使用
 * @modified By：
 * @version: 1.1
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("系统启动了");
    }
}
