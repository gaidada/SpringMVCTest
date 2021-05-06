package com.gai.controller;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    /*解析返回locale*/
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale l = null;
        String localeStr = httpServletRequest.getParameter("locale");
        if (localeStr != null && !"".equals(localeStr)) {
            l = new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
        } else {
            l = httpServletRequest.getLocale();
        }
        return l;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
