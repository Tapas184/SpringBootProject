package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeServiceInterface {

	public int getEmployeeCount();
	Map<String, Object> fetchEmpById(Integer id);
	List<Map<String, Object>> fetchEmployeeByJob(String job1, String job2);
}
