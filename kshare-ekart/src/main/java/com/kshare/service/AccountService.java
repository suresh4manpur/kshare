package com.kshare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshare.domain.Account;
import com.kshare.repository.AccountRepository;

@Service
public class AccountService {
	
@Autowired
private AccountRepository accountRepository;

public Account getAccountById(int accountId) {
	Optional<Account> optionalEntity = accountRepository.findById(accountId);
	if(!optionalEntity.isPresent()) {
		throw new AccountNotFoundException("Account id : "+accountId+" is not found!");
	}
		
	return optionalEntity.get();
}
public Account createAccount(Account account) {
	 account = accountRepository.save(account);
	 return account;
}
}
