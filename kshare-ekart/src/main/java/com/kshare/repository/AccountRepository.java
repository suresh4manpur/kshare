package com.kshare.repository;

import org.springframework.data.repository.CrudRepository;

import com.kshare.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	public Account getAccountByEmailId(String emailId);

}
