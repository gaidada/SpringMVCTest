package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/*自定义视图解析器和视图对象*/
@Controller
public class MyViewResovlerController {
    @RequestMapping("/handleplus")
    public String handleplus(Model model) {
        List<String> vname = new ArrayList<>();
        List<String> imgname = new ArrayList<>();
        vname.add("gai");
        vname.add("da");
        imgname.add("qqq");
        model.addAttribute("video", vname);
        model.addAttribute("imgs", imgname);
        return "meinv:/gaoqing";
    }
}
