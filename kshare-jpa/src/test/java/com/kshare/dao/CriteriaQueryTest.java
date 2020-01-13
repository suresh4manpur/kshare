package com.kshare.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.kshare.entity.Person;
import com.kshare.entity.Phone;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class CriteriaQueryTest {

	protected Logger logger = LoggerFactory.getLogger(CriteriaQueryTest.class);

	@Autowired
	private PersonRepository personDao;

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	EntityManager em;



	//@Test
	public void whenFindAllperson_thenReturnAllPerson_First() {
		Person person = new Person(new Timestamp(new Date().getTime()), "location", "name");
		personDao.save(person);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Person>  cq = cb.createQuery(Person.class);
		
		Root<Person> personRoot = cq.from(Person.class);
		TypedQuery<Person> query = em.createQuery(cq.select(personRoot));
		List<Person> personList = query.getResultList();
		for(Person p : personList) {
			System.out.println(p);
		}
		assertEquals("whenFindAllperson_thenReturnAllPerson", 1, personList.size());
	}
	
	@Test
	public void whenFindPersonWithoutPhone_thenReturnPerson_WithoutPhone() {
		Person person = new Person(new Timestamp(new Date().getTime()), "Patna", "Suresh");
		Phone p1  = new Phone("11111111111");
		Phone p2  = new Phone("22222222222");
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(p1);
		phones.add(p2);
		
		person.setPhones(phones);
		personDao.save(person);
		
		Person person2 = new Person(new Timestamp(new Date().getTime()), "Gaya", "Rajesh");
		
		personDao.save(person2);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Person>  cq = cb.createQuery(Person.class);
		
		Root<Person> personRoot = cq.from(Person.class);
		Predicate phoneIsEmpty = cb.isEmpty(personRoot.get("phones"));
		
		cq = cq.where(phoneIsEmpty);
		
		TypedQuery<Person> query = em.createQuery(cq.select(personRoot));
		List<Person> personList = query.getResultList();
		for(Person p : personList) {
			System.out.println(p);
			System.out.println(p.getPhones());
		}
		assertEquals("whenFindAllperson_thenReturnAllPerson", 2, personList.size());
		assertEquals("PersonWithEmptyPhoneHaveLocation", "Gaya", personList.get(0).getLocation());
		assertEquals("PersonWithEmptyPhoneHaveName", "Rajesh", personList.get(0).getName());
	}


}
