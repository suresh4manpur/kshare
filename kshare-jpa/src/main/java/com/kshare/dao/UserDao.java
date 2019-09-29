package com.kshare.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshare.entity.User;

@Repository
public class UserDao{
	public static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}

}
