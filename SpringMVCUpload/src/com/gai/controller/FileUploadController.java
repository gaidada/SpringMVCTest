package com.gai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Controller
public class FileUploadController {
    @RequestMapping("upload")
    public String upload(@RequestParam(value = "username", required = false) String username, @RequestParam("headerimg") MultipartFile file, Model model) {

        System.out.println("上传的信息:" + file.getName() + " " + file.getOriginalFilename());
        //文件保存
        try {
            file.transferTo(new File("E:\\" + file.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("msg", "文件上传失败" + e.getMessage());
        }
        return "forward:/index.jsp";
    }


    /*多文件上传*/
    @RequestMapping("/mulUpload")
    public String mulUpload(@RequestParam(value = "username", required = false) String username, @RequestParam("headerimg") MultipartFile[] file, Model model) {


        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()) {
                //文件保存
                try {
                    multipartFile.transferTo(new File("E:\\" + multipartFile.getOriginalFilename()));
                    model.addAttribute("msg", "文件上传成功");
                } catch (IOException e) {
                    model.addAttribute("msg", "文件上传失败" + e.getMessage());
                }
            }
        }

        return "forward:/index.jsp";
    }
}
