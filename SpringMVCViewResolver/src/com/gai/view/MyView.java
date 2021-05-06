package com.gai.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class MyView implements View {
    /*返回的数据的内容类型*/
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("之前保存的数据" + map);
        httpServletResponse.setContentType("text/html");
        List<String> vn = (List<String>) map.get("video");
        httpServletResponse.getWriter().write("<h1>哈哈哈</h1>");
        for (String s : vn) {
            httpServletResponse.getWriter().write("<a>" + s + "</a><br/>");
        }
    }
}
