package com.kshare.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.kshare.domain.Account;
import com.kshare.dto.AccountDTO;
import com.kshare.service.AccountService;


@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModelMapper mapper;
	

	@RequestMapping(method = RequestMethod.GET, value =  "/{accountId}", produces = "Application/json")
	public @ResponseBody AccountDTO getAccoutById(@PathVariable int accountId) {
		
		Account account = accountService.getAccountById(accountId);
		AccountDTO accountDto = mapper.map(account, AccountDTO.class);

		return accountDto;
	}
	
	@RequestMapping(method= RequestMethod.POST, consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
		
		
		/*
		 * Account account = new Account(); account.setUserId(accountDTO.getUserId());
		 * account.setPassword(accountDTO.getPassword());
		 * account.setName(accountDTO.getName());
		 * account.setEmailId(accountDTO.getEmailId());
		 */		
		//account.setAccountId(accountId);
		
		Account account = mapper.map(accountDTO, Account.class);
		account = accountService.createAccount(account);
		
		URI newAccountURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{accountId}")
				.buildAndExpand(account.getAccountId())
				.toUri();

		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newAccountURI);
		
		return new ResponseEntity<>(account, responseHeaders,HttpStatus.CREATED);
		
	}
}
