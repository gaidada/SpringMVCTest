package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController {
    @RequestMapping("/handle01")
    public String handle01(Integer i) {
        System.out.println("handle01");
        System.out.println(10 / i);
        return "success";
    }

    /*告诉SpringMVC这个方法专门处理这个类发生的异常*/
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException01(Exception exception) {
        System.out.println("handleException01" + exception);

        ModelAndView view = new ModelAndView("myerror");
        view.addObject("ex", exception);
        return view;
    }


    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String username) {
        if (!"admin".equals(username)) {
            System.out.println("登录失败");
            throw new UserNameNotFoundException();
        }
        System.out.println("登录成功");
        return "success";
    }

    @RequestMapping("/handle04")
    public String handle04() {
        System.out.println("handle04");
        String string = null;
        System.out.println(string.charAt(0));
        return "success";
    }
}
