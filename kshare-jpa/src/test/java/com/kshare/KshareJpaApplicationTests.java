package com.kshare;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.kshare.dao.PersonDao;
import com.kshare.entity.Person;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class KshareJpaApplicationTests {
	
	@Autowired
	private PersonDao personDao;

	@Test
	@Order(value = 1)
	public void whenInsertPerson_WhenLoadBykey_thenGetPerson() {
		Person person = new Person(new Timestamp(new Date().getTime()), "location", "name");
		Person responsePerson = personDao.addPerson(person);
	    assertEquals("Perosn Name", "name", responsePerson.getName());
	    assertEquals("Perosn Location", "location", responsePerson.getLocation());

	}	
	@Test
	@Order(value = 2)
	public void whenFindByName_thenReturnPerson() {
	    Person person = personDao.getPersonById(1);
	    assertEquals("Perosn Name", "Suresh", person.getName());
	    assertEquals("Person Id", 1, person.getId());
	}
	
	@Test
	@Order(value = 3)
	public void whenFindAllperson_thenReturnAllPerson_First() {
		List<Person> persons = personDao.getAllPerson();
		assertEquals("whenFindAllperson_thenReturnAllPerson", 3, persons.size());
	}
	
	@Test(expected = RuntimeException.class)
	@Order(value = 4)
	public void whenDeletePersonById_thenRecordBeDeleted() {
		personDao.deletePersonById(4);
		//personDao.getPersonById(1);
	}

	@Test(expected = RuntimeException.class)
	@Order(value = 5)
	public void whenDeletePersonById_thenThrowException() {
		personDao.deletePersonById(1);
		personDao.getPersonById(1);
	}
	@Test
	@Order(value = 6)
	public void whenUseJPQL_thenGetListOfPerson() {
		List<Person> persons = personDao.getPersonsByName("Suresh");
		assertEquals("Size test", 1, persons.size());
	}
	
	@Test
	@Order(value = 7)
	public void whenUseJPQL_thenGetPersonsByNameAndLocation() {
		List<Person> persons = personDao.getPersons("Suresh", "Gaya");
		assertEquals("Size test", 1, persons.size());
	}

}
