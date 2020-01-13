package com.kshare.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kshare.KshareJpaApplication;
import com.kshare.dao.EmployeeDao;
import com.kshare.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	protected Logger log = LoggerFactory.getLogger(KshareJpaApplication.class);
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeDao.getEmployeeByid(id);

	}
	@GetMapping("/department/{id}")
	public List<Employee >getEmployeeByDepartmentId(@PathVariable String id) {
		return employeeDao.getEmployeesByDepartment(id);

	}
}
