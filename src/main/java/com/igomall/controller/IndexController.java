package com.igomall.controller;

import com.igomall.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/user")
    public String user(Long id, ModelMap model){
        model.addAttribute("id",id);
        return "user";
    }

    @MessageMapping("/message")
    public void message(Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getToUserId(),"/message/get",message);

    }
}
