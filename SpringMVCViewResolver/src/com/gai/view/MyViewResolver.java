package com.gai.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyViewResolver implements ViewResolver, Ordered {
    private Integer order = 0;

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        //根据视图名返回视图对象
        if (s.startsWith("meinv:")) {
            return new MyView();
        } else {
            return null;
        }

    }

    @Override
    public int getOrder() {
        return order;
    }

    /*改变视图解析器的优先级*/
    public void setOrder(Integer order) {
        this.order = order;
    }
}
