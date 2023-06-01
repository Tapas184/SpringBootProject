package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IDaoEmployeeInterface {
	public int getEmployeeCount(); //for single object
	Map<String,Object> getEmployeById(Integer id); //for single row object
	List<Map<String, Object>> getEmployeListByJob(String job1, String job2); // for List of object 

}
