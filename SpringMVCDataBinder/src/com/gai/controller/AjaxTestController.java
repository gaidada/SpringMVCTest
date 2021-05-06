package com.gai.controller;

import com.gai.bean.Employee;
import com.gai.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

@Controller
public class AjaxTestController {
    @Autowired
    EmployeeDao employeeDao;

    /*HttpEntity能获取请求头和请求体*/
    @RequestMapping("/test01")
    public String test01(HttpEntity<String> str) {
        System.out.println(str);
        return "success";
    }

    @RequestMapping("down")
    public ResponseEntity<byte[]> down(HttpServletRequest request) throws IOException {
        //得到要下载的文件的流
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("jquery-1.9.1.min.js");
        FileInputStream is = new FileInputStream(realPath);
        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        //将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", "attachment;filename" + "jquery-1.9.1.min.js");
        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }


    //@ResponseBody
    @RequestMapping("/haha")
    public ResponseEntity<String> haha() {
        String body = "<h1>success</h1>";
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Set-Cookie", "username=haha");
        return new ResponseEntity<String>(body, headers, HttpStatus.OK);
    }

    /*将返回的数据放在响应体中，如果是对象，jackson自动将对象转为json格式*/
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll() {
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }

    /*获取请求体*/
    @RequestMapping("/testRequestBody")
    public String testRequestBody(Employee employee) {
        System.out.println(employee);
        return "success";
    }
}
