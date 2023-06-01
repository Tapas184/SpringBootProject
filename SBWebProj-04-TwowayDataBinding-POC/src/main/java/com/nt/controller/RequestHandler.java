package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;
@Controller
public class RequestHandler {
	
	@GetMapping("/")
	public  String welcomeHome() {
		System.out.println("welcomeHome()-Method");
		//Logical View Name for home.jsp
		return "home";
	}
	@GetMapping("/register")
	public String registerRequestHandler(@ModelAttribute("emp") Employee emp) {
	System.out.println("registerRequestHandler()");
	return "emp_register";
	}
	@PostMapping("/register")
	public String employeeRegisterPostRequest(Map<String, Object> map, 
			                                   @ModelAttribute("emp") Employee emp) {
		System.out.println("employeeRegisterPostRequest()");
		
		return "result";
	}
}//end of requestHandler class
