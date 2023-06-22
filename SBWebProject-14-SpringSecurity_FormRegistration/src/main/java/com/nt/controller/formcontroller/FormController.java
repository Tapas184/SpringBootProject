package com.nt.controller.formcontroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.CustomerModel;
import com.nt.service.ICustomerService;

@Controller
public class FormController {
	@Autowired
	private ICustomerService service;
	@GetMapping("/reg_cust")
	public String showForm(@ModelAttribute("cust") CustomerModel cust) {
		// return LVN
		return "reg_form";
	}

	@PostMapping("/reg_cust")//for form page
	public String getForm(@ModelAttribute("cust") CustomerModel cust, 
			                HttpSession ses,
			                              Map<String, Object> map) {
		//call the business method
		String result = service.customerRegister(cust);
		//put the message into Session attributes
		ses.setAttribute("message", result);
		//set Max session Interval time to expire
		ses.setMaxInactiveInterval(7);
		
		//return the LVN to Dispatcher servlet
		return "redirect:reg_cust";
	}

	@GetMapping("/cust_login")
	public String showLogin(Model model) {
		//keep the Login user name
			return "cust_login";
	}
	@GetMapping("/home_auth")
	public String authenticateHome(Model model) {
		//get the login user name
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		//put the name into Model
		model.addAttribute("msg", userName);
		return "home_Auth";
	}
}// end class FormController
