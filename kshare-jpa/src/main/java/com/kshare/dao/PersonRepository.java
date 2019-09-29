package com.kshare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kshare.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	@Query("select p from Person p where p.name = ?1")
	public List<Person> getPersonByName(String name);
	
	@Query("select p from Person p where p.name = ?1 and p.location = ?2")
	public List<Person> getPersons(String name, String location);
}
