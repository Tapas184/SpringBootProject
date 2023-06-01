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
	public String fetchEmployeeById(Integer id) {
		return (dao.getEmployeeNameById(id)==null)?"Employee not found":
			                                       "Employee Name is :"+dao.getEmployeeNameById(id);
		 
	}

	@Override
	public List<Employee> fetchEmployeeByJob(String deg1, String deg2) {
		return dao.getEmployeeListByJob(deg1, deg2);
	}

	
}
