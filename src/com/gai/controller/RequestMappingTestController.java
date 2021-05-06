package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingTestController {
    @RequestMapping("/handle01")
    public String handle01() {
        System.out.println("RequestMappingTestController  handle01");
        return "success";
    }

    /*
     * RequestMapping的属性
     * method 限定请求方式，GET/POST，默认是全接受
     * params 规定请求参数
     * headers 规定请求头，可以写简单的表达式
     * consumes 只接受内容类型是哪种的请求，规定请求头中的Context-Type
     * produces 告诉浏览器返回的内容类型是什么，给响应头加上Content-Type
     * */
    @RequestMapping(value = "handle02", method = RequestMethod.POST)
    public String handle02() {
        return "success";
    }

    @RequestMapping(value = "handle03", params = {"username!=root", "pwd"})
    public String handle03() {
        return "success";
    }

    @RequestMapping(value = "handle04", headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.128 Safari/537.36"})
    public String handle04() {
        System.out.println("handle04");
        return "success";
    }
}
