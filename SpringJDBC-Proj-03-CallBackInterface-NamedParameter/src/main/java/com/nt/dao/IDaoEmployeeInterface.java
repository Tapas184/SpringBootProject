package com.nt.dao;

import java.util.List;
import java.util.Map;

import com.nt.model.Employee;

public interface IDaoEmployeeInterface {
	//for single object
	String getEmployeeNameById(Integer id);
	//list of employee
	List<Employee> getEmployeeListByJob(String deg1,String deg2);
}
