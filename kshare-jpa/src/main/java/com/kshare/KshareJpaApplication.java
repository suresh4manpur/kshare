package com.kshare;

import javax.servlet.Filter;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class KshareJpaApplication {

	protected Logger log = LoggerFactory.getLogger(KshareJpaApplication.class);
	
	@Bean
	public Filter shallowEtagFilter() {
		return new ShallowEtagHeaderFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KshareJpaApplication.class, args);

	}
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
