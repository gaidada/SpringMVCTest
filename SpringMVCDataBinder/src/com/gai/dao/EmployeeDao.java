package com.gai.dao;

import com.gai.bean.Department;
import com.gai.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}

	//初始ID
	private static Integer initId = 1006;

	//员工保存/更新方法
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}

		//根据部门id单独查出部门信息设置到员工对象中
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	//查询所有员工
	public Collection<Employee> getAll(){
		return employees.values();
	}

	//根据id查询某个
	public Employee get(Integer id){
		return employees.get(id);
	}

	//删除某个员工
	public void delete(Integer id){
		employees.remove(id);
	}
}
