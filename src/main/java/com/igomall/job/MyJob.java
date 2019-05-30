package com.igomall.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
public class MyJob {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void sendMessage(){
        System.out.println("来自于服务段的消息");

        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer",System.currentTimeMillis());

    }

    @Scheduled(fixedRate = 10000)
    public void sendQueueMessage() {
        System.out.println("后台一对一推送！");
        simpMessagingTemplate.convertAndSendToUser("1","/sendMessageByServer",new Date());
    }
}
