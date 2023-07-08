package com.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.SecurityEntity;
import com.security.repository.SecurityRepository;
import com.security.service.SecurityService;

@Service
public class SecurityImplementation implements SecurityService {

	@Autowired
	private SecurityRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public String addUser(SecurityEntity info) {
		info.setUserPass(encoder.encode(info.getUserPass()));
		 repo.save(info);
		 
		 return "User Save SuccessFully"+info.getId();
	}


}
