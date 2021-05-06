package com.gai.component;

import com.gai.bean.Employee;
import com.gai.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class MyStringToEmployeeConverter implements Converter<String, Employee> {
    @Autowired
    DepartmentDao departmentDao;

    /*自定义转发规则*/
    @Override
    public Employee convert(String s) {
        Employee employee = new Employee();
        if (s.contains("-")) {
            String[] split = s.split("-");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }
}
