//Service class interface
package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmployeeService{
	public List<EmployeeDto> fatchEmployeesByDesg(String[] dsgs) throws Exception;
}//class
