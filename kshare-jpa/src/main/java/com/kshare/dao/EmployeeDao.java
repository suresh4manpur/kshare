package com.kshare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshare.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeByid(Long id) {

		 Optional<Employee> optionalEmployee =  employeeRepository.findById(id);
		 if(!optionalEmployee.isPresent()) {
			 throw new RuntimeException("Person not found!");
		 }
		 
		 return optionalEmployee.get();
	}
	
	public List<Employee> getEmployeesByDepartment(String departmentId){
		List<Employee> employees = employeeRepository.getEmployeeByDepartmentId(departmentId);
		
		return employees;
	}
	

}
