package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/*springMVC把数据带给页面
 * 1)在方法处传入Map或者Model或ModelMap，给这些参数里面保存的所有数据都会放在域中，可以在页面获取-放在request域中
 * 2)方法的返回值可以变为ModeAndView类型
 * 3)springmvc提供了一种可以临时给session域中保存数据的方式@SessionAttributes，后期不推荐使用，推荐原生API
 *
 * */
@SessionAttributes(value = "msg", types = {String.class})
@Controller
public class OutputController {

    @RequestMapping(value = "/handler01")
    public String handler01(Map<String, Object> map) {
        map.put("msg", "你好");
        map.put("hh", "哈哈");
        System.out.println(map.getClass());
        return "success";
    }

    @RequestMapping(value = "/handler02")
    public String handler02(Model model) {
        model.addAttribute("msg", "你好你好");
        model.addAttribute("hh", 13);
        System.out.println(model.getClass());
        return "success";
    }

    @RequestMapping(value = "/handler03")
    public String handler03(ModelMap modelMap) {
        modelMap.addAttribute("msg", "你好你好你好");
        System.out.println(modelMap.getClass());
        return "success";
    }

    /*返回值是ModelAndView，可以为页面携带数据*/
    @RequestMapping("/handle04")
    public ModelAndView handler04() {
        //之前的返回值我们就叫视图名，视图名解析器会帮我们最终拼串得到页面的真实地址
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg", "你好view");
        return view;
    }


}
