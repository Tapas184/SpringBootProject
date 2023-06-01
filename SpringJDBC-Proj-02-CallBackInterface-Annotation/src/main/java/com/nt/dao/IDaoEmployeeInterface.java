package com.nt.dao;

import java.util.List;
import java.util.Map;

import com.nt.model.Employee;


public interface IDaoEmployeeInterface {

	Employee getEmployeeByID(Integer id);
	List<Employee> getEmployeeByJob(String job1,String job2);
}
