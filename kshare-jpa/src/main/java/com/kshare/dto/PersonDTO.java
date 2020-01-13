package com.kshare.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kshare.entity.Person;
import com.kshare.entity.Phone;

public class PersonDTO {
	private int id;
	
	private Timestamp birth_date;
	private String location;
	private String name;
	private List<String> phones = new ArrayList<String>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Timestamp birth_date) {
		this.birth_date = birth_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public static PersonDTO createPersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		
		personDTO.id = person.getId();
		personDTO.birth_date = person.getBirth_date();
		personDTO.location = person.getLocation();
		personDTO.name = person.getName();
		
		for(Phone phone : person.getPhones()) {
			personDTO.phones.add(phone.getPhoneNumber());
		}
		return personDTO;
	}
	
	public static List<PersonDTO> createPersonDTOs(Iterable<Person> persons){
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		PersonDTO personDTO = null;
		for(Person person : persons) {
			personDTO = createPersonDTO(person);
			personDTOs.add(personDTO);
		}
		return personDTOs;
		
	}
	public Person createPerson() {
		Person person = new Person();
		person.setId(this.getId());
		person.setBirth_date(this.getBirth_date());
		person.setLocation(this.location);
		person.setName(this.getName());
		List<Phone> phones = new ArrayList<Phone>();
		for(String phoneNumberString : this.phones) {
			Phone phone = new Phone();
			phone.setPhoneNumber(phoneNumberString);
			phones.add(phone);
		}
		person.setPhones(phones);
		return person;
		
	}
	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", birth_date=" + birth_date + ", location=" + location + ", name=" + name
				+ ", phones=" + phones + "]";
	}

	
	

}
