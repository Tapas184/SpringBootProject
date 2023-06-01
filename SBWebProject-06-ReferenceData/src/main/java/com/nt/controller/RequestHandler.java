package com.nt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Person;
import com.nt.service.IPersonService;

@Controller
public class RequestHandler {

	@Autowired
	private IPersonService service;
	
	@GetMapping("/")
	public String homePage() {
		//retrun logical view name
		return "home";
	}//homePage(-)
	
	@ModelAttribute("countriesInfo")
	public Set<String> allCountries(@ModelAttribute("cust") Person per){
		return service.getAllCountry();
	}
	@ModelAttribute("languageInfo")
	public Set<String> languages(@ModelAttribute("cust") Person per){
		return service.getAllLanguages();
	}
	@ModelAttribute("hubbiesInfo")
	public Set<String> hobbies(@ModelAttribute("cust") Person per){
		return service.getAllHobbies();
	}
	
	@GetMapping("/person_register")
	public String showPersonRegistrationpage(@ModelAttribute("cust") Person per) {
		//Model attributes for binding data with Person model class properties
		return "person_form";
	}//close method(showPersonRegistrationpage)

}//end of request Handler class
