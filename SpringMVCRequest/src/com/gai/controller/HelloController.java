package com.gai.controller;

import com.gai.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String handler1() {
        System.out.println("handler01");
        return "success";
    }

    /*springMVC如何获取请求带来的各种信息
     * @RequestParam 获取请求参数
     * @RequestHeader 获取请求头中某个key的值
     * @CookieValue 获取某个cookie值
     * */
    @RequestMapping("/handle01")
    public String handler01(@RequestParam(value = "user", required = false, defaultValue = "111") String username,
                            @RequestHeader(value = "User-Agent") String userAgent, @CookieValue("JSESSIONID") String jid) {
        System.out.println("变量的值" + username);
        System.out.println("请求头中的信息" + userAgent);
        System.out.println("cookie的值" + jid);
        return "success";
    }

    /*
     * 如果请求参数是一个POJO，springMVC会自动的为这个pojo进行赋值
     *
     * */
    @RequestMapping("/book")
    public String addBook(Book book) {
        System.out.println("图书" + book);
        return "success";
    }
    /*
     * springMVC可以直接在参数写原生API
     * */

    @RequestMapping("/handle03")
    public String handle03(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("reqParam", "请求域中的");
        session.setAttribute("sessionParam", "session域中的");
//        response.getOutputStream();
        return "success";
    }

}
