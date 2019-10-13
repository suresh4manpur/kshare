package com.kshare.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	@Embedded
	@AttributeOverrides({ 
			@AttributeOverride(name = "state", column = @Column(name = "province")),
			@AttributeOverride(name = "zip", column = @Column(name = "postal_code")) 
			})
	private Address address;

	/*
	 * @OneToMany(mappedBy = "comapany") private List<Employee> employees = new
	 * ArrayList<Employee>();
	 */
	

	public Company(String name) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	/*
	 * public List<Employee> getEmployees() { return employees; }
	 * 
	 * public void setEmployees(List<Employee> employees) { this.employees =
	 * employees; }
	 */

}
