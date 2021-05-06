package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "../hello";
    }

    @RequestMapping("/handle01")
    public String handle01() {
        return "forward:/hello.jsp";
    }

    @RequestMapping("/handle02")
    public String handle02() {
        return "forward:/handle01";
    }

    /*重定向*/
    @RequestMapping("/handle03")
    public String handle03() {
        return "redirect:/hello.jsp";
    }

    @RequestMapping("/handle04")
    public String handle04() {
        return "redirect:/handle03";
    }

/*    @RequestMapping("/toLoginPage")
    public String toLogin() {
        return "forward:/pages/login.jsp";
    }*/
}
