package com.gai.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*集中处理所有异常*/
@ControllerAdvice
public class MyException {
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException03(Exception exception) {
        System.out.println("handleException03" + exception);

        ModelAndView view = new ModelAndView("myerror");
        view.addObject("ex", exception);
        return view;
    }
}
