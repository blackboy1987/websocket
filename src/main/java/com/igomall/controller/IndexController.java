package com.igomall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/user")
    public String user(Long id, ModelMap model){
        model.addAttribute("id",id);
        return "user";
    }
}
