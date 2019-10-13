package com.kshare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String name;
private String Description;

@ManyToOne
private Employee employee;


public Device() {
	super();
	// TODO Auto-generated constructor stub
}
public Device(String name, String description) {
	super();
	this.name = name;
	Description = description;
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
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}


}
