package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;
@Service("service")
public class EmployeeImplementService implements IEmployeeService {
	
	@Autowired
	//Inject dependency in target class through autowired
	private IEmployeeRepository repo;
	@Override
	public String insertEmployee(Employee e) {
		return "Employee Registered with id :: "+repo.save(e).getEmpno();
	}

}//end of class EmployeeImplementService
