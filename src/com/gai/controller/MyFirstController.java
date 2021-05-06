package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*告诉springMvc这是一个处理器，可以处理请求*/
@Controller
public class MyFirstController {
    /*RequestMapping告诉spring MVC，这个方法用来处理什么请求
    * */
    @RequestMapping("/hello")
    public String myFirstRequest() {
        System.out.println("请求收到了，正在处理中");
        //视图解析器自动拼串
        return "success";
    }
}
