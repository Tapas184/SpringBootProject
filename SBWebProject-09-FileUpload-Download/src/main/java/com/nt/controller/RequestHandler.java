package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller
//make this class as spring bean class 
//this class for request mapping
public class RequestHandler {
	@Autowired
	private IEmployeeService service;
	
	//for Welcome page Ds will trap the request and will give to handler for mapping
	@GetMapping("/")
	public String showHome() {
		//return LogicalView Name
		return "home";
	}
	
	//for show form page
	@GetMapping("/reg")
	public String showFormPage(@ModelAttribute("emp") Employee emp) {
		//for two-way binding the data @modelattributes required
		return "emp_reg";
	}
}//end of class RequestHandler
