package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repositry.IEmployeeRepository;
@Service //make this calss as spring Bean class
public class EmployeeServiceImplementation implements IEmployeeService {

	@Autowired
	//inject dependency through @Autowired
	private IEmployeeRepository repo;
	@Override
	public Iterable<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("ename"));
	}

}
