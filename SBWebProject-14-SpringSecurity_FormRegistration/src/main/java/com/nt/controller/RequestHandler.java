package com.nt.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.CustomerModel;

@Controller
public class RequestHandler {
	
	//showing home page
	@GetMapping("/")
	public String showHome(HttpSession ses) {
		//return LVN
		return "home";
	}
	@GetMapping("/check_balance")
	public String checkBalance(Map<String,Object> map) {
		int number = new Random().nextInt(10000);
		//add the number in Attributes for binding
		map.put("current_balance",number);
	return "balance";
	}
	@GetMapping("/check_loan")
	public String checkLoan(Map<String,Object> map) {
		String intrest="0.2%";
		String  time ="1 year";
		//put into map
		map.put("intrest", intrest);
		map.put("time", time);
		return"offer";
	}
	
	@GetMapping("/acc_denined")
	public String accessDenined(Model model) {
		//get the Login user name
		String userName=	SecurityContextHolder.getContext().getAuthentication().getName();
		if(userName!=null)
		model.addAttribute("username", userName);
			return "acc_denined";
	}
	@GetMapping("/session_timeout")
	public String sessionTimeOut() {
		return "session_timeout";
	}
}//
