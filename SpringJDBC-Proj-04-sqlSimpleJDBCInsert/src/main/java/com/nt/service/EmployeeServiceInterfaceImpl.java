package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IDaoEmployeeInterface;
import com.nt.model.Employee;
@Service("service") //annotation made the class for java bean
public class EmployeeServiceInterfaceImpl implements IEmployeeServiceInterface {

	@Autowired
	private IDaoEmployeeInterface dao;
	
	@Override
	public String registerEmployee(Employee e) {
		int count=dao.insertEmployee(e);
		return count==0?"Error in registering Employee..Try again ":"Employee registered with id "+e.getEmpno();
	}
	
}
