package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.model.Customer;
import com.nt.repositry.ICustomerRepo;

@Service("service")
public class CustomerImpService implements ICustomerService {
	
	//inject dependency by @Autowired
	@Autowired//make the method as java bean
	private ICustomerRepo repo;

	@Override
	public Iterable<Customer> getAllCustomer() {
		return repo.findAll(Sort.by("custname"));
	}

}
