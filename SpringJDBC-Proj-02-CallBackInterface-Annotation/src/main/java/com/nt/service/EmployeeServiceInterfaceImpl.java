package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IDaoEmployeeInterface;
import com.nt.model.Employee;

@Service("service")
public class EmployeeServiceInterfaceImpl implements IEmployeeServiceInterface {

	@Autowired
	private IDaoEmployeeInterface dao;

	@Override
	public Employee fetchById(Integer id) {
		return dao.getEmployeeByID(id);
	}//fetchById

	@Override
	public List<Employee> fetchByJob(String job1, String job2) {
		return dao.getEmployeeByJob(job1, job2);
	}//fetchByJob
}//EmployeeServiceInterfaceImpl
