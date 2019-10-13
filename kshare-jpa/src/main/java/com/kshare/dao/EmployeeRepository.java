package com.kshare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshare.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
