package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller //Make this class as spring bean class
public class RequestHandler {
	
	//inject dependency
	@Autowired
	private IEmployeeService service;
	//for home page
	@GetMapping("/") //Mapp the request by "/"
	public String showHomePage() {
		//return logical view name(LVN)
		return "home";
	}
	
	@GetMapping("/report")
	//mapin the request for "/report"
	public String requestForPDF(@RequestParam("type") String type, Map<String,Object> map ) {
		//call the service method
		Iterable<Employee> emplist = service.findAllEmployee();
		//put into the Map for buinding the data
		map.put("listofemp", emplist);
		//return LVN to DS
		if(type.equalsIgnoreCase("pdf"))
			return "pdf_report";
		else
			return "excel_report";
	}

}//end of class RequestHandler
