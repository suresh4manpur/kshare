package com.kshare.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department department;

    
	@OneToOne(mappedBy = "epmployee")
	// @JoinColumn(name="park_space_id")
	private ParckingSpace parkingSpace;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "emp_proj", joinColumns = @JoinColumn(name = "emp_id"),
	  inverseJoinColumns = @JoinColumn(name = "proj_id"))
	private List<Project> projects = new ArrayList<Project>();
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name = "EMP_HOBBIES")
	@OrderBy
	private List<String> hobies = new ArrayList<String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@AttributeOverrides({
		@AttributeOverride(name = "startDate" , column = @Column(name="furolough_date")),
		@AttributeOverride(name = "daysTaken" , column = @Column(name="leaves"))
	})
	@CollectionTable(name = "EMP_VACATION", joinColumns = @JoinColumn(name="emp_id"))
	@OrderBy(value = "daysTaken DESC")
	private List<VacationEntry> vacationEntry = new ArrayList<VacationEntry>();
	
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "emp_device_details")
	 * 
	 * @MapKeyColumn(name = "device_type")
	 * 
	 * @MapKeyEnumerated(EnumType.STRING)
	 * 
	 * @Column(name = "device_description") private Map<DeviceType, Device>
	 * deviceDetails;
	 */
	
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	//@MapKeyColumn(name = "DEV_TYPE_ID")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<DeviceType, Device> deviceDetails;



	public Map<DeviceType, Device> getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(Map<DeviceType, Device> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

	public List<String> getHobies() {
		return hobies;
	}

	public void setHobies(List<String> hobies) {
		this.hobies = hobies;
	}

	public List<VacationEntry> getVacationEntry() {
		return vacationEntry;
	}

	public void setVacationEntry(List<VacationEntry> vacationEntry) {
		this.vacationEntry = vacationEntry;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(long id, String name, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Employee(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParckingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParckingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
