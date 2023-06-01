package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.model.Employee;

public interface IEmployeeServiceInterface {

	String fetchEmployeeById(Integer id);
	List<Employee> fetchEmployeeByJob(String deg1, String deg2);
}
