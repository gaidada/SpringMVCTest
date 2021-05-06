package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * RequestMapping模糊匹配功能
 * URL地址可以写模糊的通配符
 * ？ 能替代任意一个字符
 * *  能替代任意多个字符和一层路径
 * ** 能替代多层路径
 * */
@Controller
public class RequestMappingTest {
    @RequestMapping("/antTest01")
    public String antTest01() {
        System.out.println("ant01");
        return "success";
    }

    @RequestMapping("/antTest0?")
    public String antTest02() {
        System.out.println("ant02");
        return "success";
    }

    @RequestMapping("/antTest0*")
    public String antTest03() {
        System.out.println("ant03");
        return "success";
    }

    @RequestMapping("/a/*/antTest0*")
    public String antTest04() {
        System.out.println("ant04");
        return "success";
    }

    @RequestMapping("/a/**/antTest0*")
    public String antTest05() {
        System.out.println("ant05");
        return "success";
    }

    //路径上可以有占位符
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id") String id) {
        System.out.println("路径上的占位符的值" + id);
        return "success";
    }
}
