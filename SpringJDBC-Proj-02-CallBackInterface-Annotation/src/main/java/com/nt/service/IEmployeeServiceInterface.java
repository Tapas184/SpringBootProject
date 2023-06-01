package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.model.Employee;

public interface IEmployeeServiceInterface {

	Employee fetchById(Integer id);
	List<Employee> fetchByJob(String job1, String job2);
}
