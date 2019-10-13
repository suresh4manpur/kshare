package com.kshare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshare.entity.Department;

@Repository
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department getDepartment(Department depart) {
		return departmentRepository.save(depart);
	}
	
}

