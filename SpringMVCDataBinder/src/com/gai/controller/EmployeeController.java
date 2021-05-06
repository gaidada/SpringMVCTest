package com.gai.controller;

import com.gai.bean.Department;
import com.gai.bean.Employee;
import com.gai.dao.DepartmentDao;
import com.gai.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /*查询所有员工*/
    @RequestMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    /*去员工添加页面，去页面之前需要查出部门信息*/
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model) {

        model.addAttribute("employee", new Employee());
        return "add";
    }

    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empinfo") Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /*保存员工*/
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult result, Model model) {
        System.out.println("要添加的员工" + employee);
        //获取是否有校验错误
        boolean hasErrors = result.hasErrors();
        Map<String, Object> errorsMap = new HashMap<>();
        if (hasErrors) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getDefaultMessage());
                System.out.println(error.getField());
                System.out.println(error);
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("errorInfo", errorsMap);
            return "add";
        } else {
            employeeDao.save(employee);
            return "redirect:/emps";
        }


    }

    /*查询员工*/
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id, Model model) {
        //查出员工信息
        Employee employee = employeeDao.get(id);
        //放到请求域中
        model.addAttribute("employee", employee);
        //部门信息放在隐含模型中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "edit";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        System.out.println("要修改的员工" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee", employee);
        }
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
    }

    /*删除*/
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
