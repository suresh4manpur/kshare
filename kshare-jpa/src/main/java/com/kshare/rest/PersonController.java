package com.kshare.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kshare.KshareJpaApplication;
import com.kshare.dao.PersonRepository;
import com.kshare.dto.PersonDTO;
import com.kshare.entity.Person;

@Controller
@RequestMapping("/persons")
public class PersonController {
	protected Logger log = LoggerFactory.getLogger(KshareJpaApplication.class);
	
	@Autowired
	PersonRepository personDao;
	
	@Autowired
	ModelMapper mapper;
	
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage handle(){
		
		ErrorMessage errorMessage= new ErrorMessage();
		errorMessage.setMessage("Cluster is not Found!!!");
		
		return errorMessage;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody PersonDTO getPersonById(@PathVariable int id) {
		log.debug("PersonControl. getPersonById().. entry");
		Optional<Person> person =  personDao.findById(id);
		if(!person.isPresent()) {
			throw new PersonNotFoundException("Person not found!");
		}
		
		//PersonDTO personDTO = mapper.map(person, PersonDTO.class);
		PersonDTO personDTO = PersonDTO.createPersonDTO(person.get());
		log.debug("personDTO : "+person);
		return personDTO;

	}
	
	@GetMapping
	public @ResponseBody List<PersonDTO> getAllPerson() {
		log.debug("PersonControl. getPersonById().. entry");
		List<Person> persons =  personDao.findAll();
		
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		personDTOs = PersonDTO.createPersonDTOs(persons);		 
		log.debug("personDTOs : "+personDTOs);
		return personDTOs;

	}
	@PostMapping
	public @ResponseBody ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
		Person person = personDTO.createPerson();
		personDao.save(person);
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(person.getId())
		.toUri();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);
		
		return new ResponseEntity<PersonDTO>(null, httpHeaders, HttpStatus.OK);
				
		
		
	}
	
	
	
}
