package com.kshare.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.kshare.KshareJpaApplication;
import com.kshare.entity.Person;
import com.kshare.entity.Phone;
import com.kshare.view.PersonPhoneView;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class PersonDaoTest {

	protected Logger logger = LoggerFactory.getLogger(PersonDaoTest.class);

	@Autowired
	private PersonRepository personDao;

	@Autowired
	PersonRepository personRepository;

	@Test
	@Order(value = 1)
	public void whenInsertPerson_WhenLoadBykey_thenGetPerson() {
		Person person = new Person(new Timestamp(new Date().getTime()), "location", "name");
		Person responsePerson = personDao.save(person);
		assertEquals("Perosn Name", "name", responsePerson.getName());
		assertEquals("Perosn Location", "location", responsePerson.getLocation());

	}

	@Test
	@Order(value = 2)
	public void whenFindByName_thenReturnPerson() {
		Optional<Person> personOptional = personDao.findById(1);
		Person person = personOptional.get();
		assertEquals("Perosn Name", "Suresh", person.getName());
		assertEquals("Person Id", 1, person.getId());
	}

	@Test

	@Order(value = 3)
	public void whenFindAllperson_thenReturnAllPerson_First() {
		List<Person> persons = personDao.findAll();
		assertEquals("whenFindAllperson_thenReturnAllPerson", 3, persons.size());
	}

	@Test(expected = RuntimeException.class)

	@Order(value = 4)
	public void whenDeletePersonById_thenRecordBeDeleted() {
		//personDao.deletePersonById(4); 
		personDao.deleteById(4);
		// personDao.getPersonById(1);
	}

	@Test(expected = RuntimeException.class)

	@Order(value = 5)
	public void whenDeletePersonById_thenThrowException() {
		personDao.deleteById(1);

		personDao.findById(1);
	}

	@Test

	@Order(value = 6)
	public void whenUseJPQL_thenGetListOfPerson() {

		List<Person> persons = personDao.getPersonByName("Suresh");
		assertEquals("Size test", 1, persons.size());
	}

	@Test

	@Order(value = 7)
	public void whenUseJPQL_thenGetPersonsByNameAndLocation() {
		List<Person> persons = personDao.getPersons("Suresh", "Gaya");
		assertEquals("Size test", 1, persons.size());
	}

	@Test

	@Order(value = 8)
	public void whenUseJPQL_thenGetPersonsByLocation() { //
		personDao.save(new Person(new Timestamp(new Date().getTime()), "Gaya", "Rajesh"));

		List<Person> persons = personDao.getPersonByLocation("Gaya");
		assertEquals("whenUseJPQL_thenGetPersonsByLocation", 1, persons.size());

	}

	@Test

	@Order(value = 9)
	public void whenPersonWithPhones_thenGetPersonsWithPhoneGetsCreated() { //
		personDao.save(new Person(new Timestamp(new Date().getTime()), "Gaya", "Rajesh"));

		Person person = new Person(1, new Timestamp(new Date().getTime()), "Manpur", "Anuj");
		person.getPhones().add(new Phone("24352345425"));
		person.getPhones().add(new Phone("11111111111"));
		Person responsePerson = personDao.save(person);

		assertEquals("whenUseJPQL_thenGetPersonsByLocation", "24352345425",
				responsePerson.getPhones().get(0).getPhoneNumber());
		assertEquals("whenUseJPQL_thenGetPersonsByLocation", "11111111111",
				responsePerson.getPhones().get(1).getPhoneNumber());

	}

	@Test
	@Order(value = 10)
	public void jpq_test1() {
		personDao.save(new Person(new Timestamp(new Date().getTime()), "Gaya", "Harish"));

		Person person = new Person(new Timestamp(new Date().getTime()), "Manpur", "Raghu");
		person.getPhones().add(new Phone("11117777"));
		person.getPhones().add(new Phone("22226666"));
		personDao.save(person);

		List<PersonPhoneView> list = personRepository.getPersonPhoneView();
		for (PersonPhoneView view : list) {
			logger.info("PersonView {}", view);

		}

	}
	
	@Test
	@Order(value = 11)
	public void jpq_test_by_location() {
		personDao.save(new Person(new Timestamp(new Date().getTime()), "Gaya", "Mahesh"));

		Person person = new Person(new Timestamp(new Date().getTime()), "Gaya", "Devesh");
		Phone p1= new Phone("9090909090");
		Phone p2= new Phone("7070707070");
		
		p1.setPerson(person);
		p2.setPerson(person);
		
		person.getPhones().add(p1);
		person.getPhones().add(p2);
		
		personDao.save(person);

		List<PersonPhoneView> list = personRepository.getPersonPhoneViewByLocation("Gaya");
		for (PersonPhoneView view : list) {
			logger.info("PersonView {}", view);

		}

	}

}
