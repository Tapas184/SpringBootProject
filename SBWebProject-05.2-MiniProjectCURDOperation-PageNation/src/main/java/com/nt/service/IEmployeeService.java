package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	//Employee get by page nation
	public Page<EmployeeModel> getEmployee(Pageable pageable);

}//service Interface
