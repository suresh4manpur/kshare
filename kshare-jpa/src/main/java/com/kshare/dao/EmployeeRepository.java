package com.kshare.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kshare.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e, Department d  where d.id = ?1")
	public List<Employee> getEmployeeByDepartmentId(String departmentId);

}
