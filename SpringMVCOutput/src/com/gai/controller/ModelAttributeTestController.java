package com.gai.controller;

import com.gai.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/*测试ModelAttribute注解
 *
 * */
@Controller
public class ModelAttributeTestController {

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam(value = "author") String author, Map<String, Object> model, HttpServletRequest request, @ModelAttribute("book") Book book) {
        System.out.println("model" + model.getClass());
        System.out.println(book);
        return "success";
    }

    /*springmvc要封装请求参数的Book对象不应该时自己new出来的
     * 而应该是从数据库中拿到的准备好的对象
     * ModelAttribute这个方法提前于目标方法先运行
     * */
    @ModelAttribute
    public void myModelAttribute(Model model) {
        Book book = new Book(100, "西游记", "吴承恩", 98, 10, 98.99);
        System.out.println("模拟数据库中的图书" + book);
        model.addAttribute("book", book);
        System.out.println("ModelAttribute方法");
    }
}
