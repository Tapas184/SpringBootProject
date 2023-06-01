package com.nt.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.ICustomerService;

@Controller
public class RequestHadlerController {

	//inject dependency through @Autowired
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/")
	public String showHome() {
		return"home";
	}
	
}//end of class RequestHadlerController
