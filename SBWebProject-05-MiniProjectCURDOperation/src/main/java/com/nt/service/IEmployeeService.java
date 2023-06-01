package com.nt.service;

import com.nt.model.EmployeeModel;

//service interface here we can define our requirement and maintain abstraction
public interface IEmployeeService {
	//for get all employee details
	public Iterable<EmployeeModel> getAllEmployee();
	//for Inserting employee 
	public String insertEmployee(EmployeeModel emp);
	//for edit link 
	public EmployeeModel getEmployeeById(Integer id);
	//update Emp details
	public String updateEmpDetails(EmployeeModel emp);
	//delete Employee by ID
	public String deleteEmployeeByID(Integer id);

}//service Interface
