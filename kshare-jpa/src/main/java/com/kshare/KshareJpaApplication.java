package com.kshare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kshare.dao.PersonDao;
import com.kshare.entity.Person;

@SpringBootApplication
public class KshareJpaApplication {

	protected Logger log = LoggerFactory.getLogger(KshareJpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KshareJpaApplication.class, args);

	}

}
