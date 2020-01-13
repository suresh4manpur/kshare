package com.kshare.view;

public class PersonPhoneView {
	
	private int personId;
	private String name;
	private String phoneNumber;

	public PersonPhoneView(int personId, String name, String phoneNumber) {
		super();
		this.personId = personId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public PersonPhoneView() {
		super();
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PersonPhoneView [personId=" + personId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
