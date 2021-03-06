package com.kshare.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String name;

@ManyToMany(mappedBy = "projects")
private List<Employee> employees = new ArrayList<Employee>();


public Project() {
	super();
	// TODO Auto-generated constructor stub
}

public Project(String name) {
	super();
	this.name = name;
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Employee> getEmployees() {
	return employees;
}

public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}



}
