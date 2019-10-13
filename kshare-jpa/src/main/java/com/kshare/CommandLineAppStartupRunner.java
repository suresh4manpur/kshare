package com.kshare;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kshare.dao.CompanyRepository;
import com.kshare.dao.DepartmentRepository;
import com.kshare.dao.EmployeeRepository;
import com.kshare.dao.ParkingSpaceRepository;
import com.kshare.dao.PersonRepository;
import com.kshare.dao.PublicationRepository;
import com.kshare.entity.Address;
import com.kshare.entity.BlogPost;
import com.kshare.entity.Book;
import com.kshare.entity.Company;
import com.kshare.entity.Department;
import com.kshare.entity.Device;
import com.kshare.entity.DeviceType;
import com.kshare.entity.Employee;
import com.kshare.entity.ParckingSpace;
import com.kshare.entity.Project;
import com.kshare.entity.Publication;
import com.kshare.entity.VacationEntry;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	PublicationRepository publicationRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enters,...");
		/*
		Project sapphire = new Project("Sapphire");
		Project pmp = new Project("PMP");
		Project espp = new Project("ESPP");
				
		Employee emp1 = new Employee("Suresh");
		Address emp1Address = new Address("Vishwapriya Layout", "Bangalore", "Karnatak", "580068");
		emp1.setAddress(emp1Address);
		
		Employee emp2 = new Employee("Rajesh");
		Address emp2Address = new Address("Immadihalli", "Bangalore", "Karnatak", "580068");
		emp2.setAddress(emp2Address);

		
		emp1.getProjects().add(sapphire);
		emp1.getProjects().add(pmp);
		emp2.getProjects().add(espp);
		
		Address companyAddress = new Address("London Bridge", "London down town", "London", "potal-123");
		Company company = new Company("Google");
		company.setAddress(companyAddress);
		

		sapphire.getEmployees().add(emp1);
		pmp.getEmployees().add(emp1);
		sapphire.getEmployees().add(emp2);

		
		  Department department = new Department("Mech", "Mecanical");
		  //departmentRepository.save(department);
		  
		  //Employee emp = new Employee("Raj", department);
		  
		
		  emp1.setDepartment(department);
		  ParckingSpace parkSpace = new
		  ParckingSpace(1, "8C"); parkSpace.setEpmployee(emp1);
		  emp1.getHobies().add("Cricket");
		  emp1.getHobies().add("Badminton");
		  
		  VacationEntry vacationEntry1 = new VacationEntry(Calendar.getInstance(), 4);
		  VacationEntry vacationEntry2 = new VacationEntry(Calendar.getInstance(), 7);
		  VacationEntry vacationEntry3 = new VacationEntry(Calendar.getInstance(), 3);
		  
		  emp1.getVacationEntry().add(vacationEntry1);
		  emp1.getVacationEntry().add(vacationEntry2);
		  emp1.getVacationEntry().add(vacationEntry3);
		  
		  Map<DeviceType,Device> empDeviceMap = new HashMap<DeviceType, Device>();
		/*
		 * empDeviceMap.put(DeviceType.MOBILE, "Red Me Note 5 pro");
		 * empDeviceMap.put(DeviceType.LAPTOP, "Lenova");
		 * empDeviceMap.put(DeviceType.PC, "Not Available");
		 */		  
		 /* 
		  Device d1 = new Device("RedMe 5 pro", "RedMe 5 pro 16000");
		  Device d2 = new Device( "Lenova", "Lenovo 59000");
		  Device d3 = new Device("Drone","NA");
		  
		  empDeviceMap.put(DeviceType.MOBILE, d1);
		  empDeviceMap.put(DeviceType.LAPTOP, d2);
		  empDeviceMap.put(DeviceType.PC, d3);
		  d1.setEmployee(emp1);
		  d2.setEmployee(emp1);
		  d3.setEmployee(emp1);

		  emp1.setDeviceDetails(empDeviceMap);
		  //emp.setParkingSpace(parkSpace);
		  
		  //empRepository.save(emp);
		  
		  parkingSpaceRepository.save(parkSpace); 
		  empRepository.save(emp2);
		 
		  companyRepository.save(company);
		  
		   List<Employee> emps = empRepository.findAll();
		   for (Employee employee : emps) {
				  for (VacationEntry vacEntry : employee.getVacationEntry()) {
					  System.out.println(vacEntry);
					
				}
		}

		   Publication book = new Book(2);
		  
		   Publication blogPost = new BlogPost("kshare.com");
		   publicationRepository.save(book);
		   publicationRepository.save(blogPost);
		 
		   */
	}
 
}
