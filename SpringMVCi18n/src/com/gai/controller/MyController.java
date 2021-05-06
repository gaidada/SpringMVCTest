package com.gai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class MyController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/toLoginPage")
    public String toLoginPage(@RequestParam(value = "locale", defaultValue = "en_US") String localeStr, Locale locale, Model model, HttpSession session) {
        System.out.println(locale);
        String welocomeinfo = messageSource.getMessage("welcomeinfo", null, locale);
        System.out.println(welocomeinfo);
        Locale l = null;
        if (localeStr != null && !"".equals(localeStr)) {
            l = new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
        } else {
            l = locale;
        }
        session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE", l);

        return "login";
    }
}
