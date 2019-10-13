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
	
	@Query(value = "select * from Person p where  p.location = ?1" , nativeQuery = true)
	public List<Person> getPersonByLocation(String location);
	
	@Query(value = "select p, ph from Person p , Phone ph where p.id = ph.person.id and p.location = ?1" )
	public List<Object[]> getPersonByLocationAndPerson(String location);
}
