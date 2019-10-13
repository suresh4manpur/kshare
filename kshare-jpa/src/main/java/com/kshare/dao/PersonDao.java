package com.kshare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kshare.entity.Person;

@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(int id) {
		 Optional<Person> optionalPerson =  personRepository.findById(id);
		 if(!optionalPerson.isPresent()) {
			 throw new RuntimeException("Person not found!");
		 }
		 
		 return optionalPerson.get();
	}
	
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}
	public void deletePersonById(int id){
		 personRepository.deleteById(id);
	}
	public List<Person> getPersonsByName(String name){
		return personRepository.getPersonByName(name);
	}
	 
	public List<Person> getPersons(String name, String location){
		return personRepository.getPersons(name, location);
	}
	
	public List<Person> getPersonByLocation(String location){
		return personRepository.getPersonByLocation( location);
	}
	
}
