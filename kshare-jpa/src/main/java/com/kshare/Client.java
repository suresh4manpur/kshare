package com.kshare;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kshare.dto.PersonDTO;
import com.kshare.entity.Employee;
import com.kshare.entity.Phone;


public class Client {

	public static void main(String[] args) throws URISyntaxException {
		

		RestTemplate restTemplate=  new RestTemplate();
		
		String baseURL="http://localhost:8080" ;		
		
		//Get the person by id
		  String getServerByIdURL = baseURL+"/persons/{id}"; 
		  ResponseEntity<PersonDTO> responseEntity = restTemplate.getForEntity(getServerByIdURL,PersonDTO.class,1);		  
		  HttpHeaders httpHeaders=responseEntity.getHeaders();		  
		  System.out.println("Headers: "+httpHeaders);		  		  
		  PersonDTO personDTO = responseEntity.getBody();		  
		  System.out.println("Person Name :"+personDTO.getName());
		  
		 //Create the person
		  
		  String personUrlString = baseURL+"/persons";
		  
		  List<String> phones = new ArrayList<String>();
		  phones.add("1000000000");
		  phones.add("1000000001");
		  
		  PersonDTO personDTO2 = new PersonDTO();
		  personDTO2.setName("Akash");
		  personDTO2.setLocation("Patna");
		  Timestamp dobTimestamp = new Timestamp(new Date().getTime());
		  personDTO2.setBirth_date(dobTimestamp);
		  personDTO2.setPhones(phones);
		  ResponseEntity<PersonDTO> responseEntity2 = restTemplate.postForEntity(personUrlString, personDTO2, PersonDTO.class);
		  responseEntity2.getHeaders();
		  System.out.println("Headers : "+responseEntity2.getHeaders());
		  System.out.println("Person Body : "+responseEntity2.getBody());
		
		// TODO -3 Use rest template to get all the servers with out headers. Iterate Over the servers and print the server name
		
		/*
		 * ParameterizedTypeReference<List<ServerDTO>> servers= new
		 * ParameterizedTypeReference<List<ServerDTO>>(){} ;
		 * 
		 * 
		 * ResponseEntity<List<ServerDTO>> responseEntities=
		 * restTemplate.exchange(baseURL+"/servers", HttpMethod.GET, null, servers);
		 * 
		 * List<ServerDTO> serverDTOs=responseEntities.getBody();
		 * 
		 * for(ServerDTO serverDTO:serverDTOs){
		 * System.out.println("Server Name : "+serverDTO.getServerName()); }
		 */
		
		//TODO-4 Use Rest Template to create a new Server .We want the URI of the newly created resource.
		//Now, make a get request to the newly created server and make sure that server name is same
		
		/*
		 * ServerDTO serverDTO= new ServerDTO();
		 * serverDTO.setServerName("Suresh Kumar");
		 * 
		 * 
		 * 
		 * URI newIRI= restTemplate.postForLocation("http://localhost:8080/servers",
		 * serverDTO);
		 * 
		 * System.out.println(newIRI);
		 */
		
		//TODO-5	Use Rest Template to create a new Server.  We want to print all the response headers and body if any
		
		/*ServerDTO serverDTO= new ServerDTO();
		serverDTO.setServerName("AAAAAA");
		
		ResponseEntity<Object> responseEntity=restTemplate.postForEntity(baseURL+"/servers", serverDTO, null);
		HttpHeaders httpHeaders=responseEntity.getHeaders();
		System.out.println(httpHeaders);
		System.out.println(responseEntity.getBody());*/
	}

}
