package com.kshare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParckingSpace {
	@Id
	private long id;
	private int lot;
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee epmployee;
	
	public ParckingSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ParckingSpace(int lot, String location) {
		super();
		this.lot = lot;
		this.location = location;
	}

	public ParckingSpace(long id, int lot, String location) {
		super();
		this.id = id;
		this.lot = lot;
		this.location = location;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getLot() {
		return lot;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee getEpmployee() {
		return epmployee;
	}
	public void setEpmployee(Employee epmployee) {
		this.epmployee = epmployee;
	}
	
	
}
