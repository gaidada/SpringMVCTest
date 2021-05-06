package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {
    @RequestMapping("/test1")
    public String test1() {
        System.out.println("test1....");
        return "success";
    }
}
