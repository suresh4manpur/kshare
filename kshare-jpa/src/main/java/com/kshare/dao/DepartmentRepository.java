package com.kshare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kshare.entity.Department;
import com.kshare.entity.Person;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
