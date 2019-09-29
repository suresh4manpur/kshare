package com.kshare.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kshare.KshareJpaApplication;
import com.kshare.dao.PersonDao;
import com.kshare.entity.Person;

@RestController
public class PersonControl {
	protected Logger log = LoggerFactory.getLogger(KshareJpaApplication.class);
	
	@Autowired
	PersonDao personDao;
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable int id) {
		log.debug("PersonControl. getPersonById().. entry");
		return personDao.getPersonById(id);

	}
}
