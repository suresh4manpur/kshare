package com.kshare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kshare.entity.Phone;

@Component
public class PhoneDao {
	@Autowired
	private PhoneRepository phoneRepository;
	public Phone savePhone(Phone phone) {
		return phoneRepository.save(phone);
	}

}
