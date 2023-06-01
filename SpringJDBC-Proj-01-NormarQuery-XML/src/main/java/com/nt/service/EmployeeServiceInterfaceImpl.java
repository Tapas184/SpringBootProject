package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.IDaoEmployeeInterface;

public class EmployeeServiceInterfaceImpl implements IEmployeeServiceInterface {

	// Dependency class-DAO
	// Target class-EmployeeServiceInterfaceImpl
	// so need to inject DAO Interface class type
	private IDaoEmployeeInterface dao;

	// take a constructor
	public EmployeeServiceInterfaceImpl(IDaoEmployeeInterface dao) {
		this.dao = dao;
	}

	@Override
	public int getEmployeeCount() {
		// call the methoda
		int count = dao.getEmployeeCount();
		return count;
	}

	@Override
	public Map<String, Object> fetchEmpById(Integer id) {
		// call thr DAO class method and pass the id
		Map<String, Object> employee = dao.getEmployeById(id);
		return employee;
	}

	@Override
	public List<Map<String, Object>> fetchEmployeeByJob(String job1, String job2) {
		//call the dao method
		List<Map<String, Object>> employee= dao.getEmployeListByJob(job1, job2);
		return employee;
	}
}
