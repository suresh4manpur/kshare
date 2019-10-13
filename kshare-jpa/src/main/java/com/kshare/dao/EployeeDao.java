package com.kshare.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshare.entity.Person;

@Repository
public class EployeeDao {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(int id) {
		//Entry point
		//step1 //validating employee details
		//[logger.info("validating employee details");
		 Optional<Person> optionalPerson =  personRepository.findById(id);
		 if(!optionalPerson.isPresent()) {
			 throw new RuntimeException("Person not found!");
		 }
		 
		 return optionalPerson.get();
		 //Exit
	}
	

}
