package com.nt.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.CustomerModel;

public interface ICustomerService extends UserDetailsService{
//for customer registration
	public String  customerRegister(CustomerModel c);
	
}//
