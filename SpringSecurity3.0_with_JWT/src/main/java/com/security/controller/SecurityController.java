package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.SecurityEntity;
import com.security.model.AuthDetails;
import com.security.service.SecurityService;
import com.security.service.impl.JWTService;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private SecurityService service;
	
	@Autowired
	private JWTService jwtServices;
	
	@Autowired
	private AuthenticationManager authManager;
	/**
	 * This method for welcome screen
	 * @return String
	 */
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcome(){
		return new ResponseEntity<>("Not asecure Site",HttpStatus.OK);
	}
	
	/**
	 * For access this method user required role admin
	 * @return String
	 */
	@GetMapping("/product")
	@PreAuthorize("hasAuthority('ADMIN')") // This is only allow which role is ADMIN
	public ResponseEntity<String> getLoginpage(){
		return new ResponseEntity<>("LoggedIn",HttpStatus.OK);
	}
	
	/**
	 * This method is used for create user
	 * @param entity
	 * @return String
	 */
	
	@PostMapping("/adduser")
	public ResponseEntity<String> saveUser(@RequestBody SecurityEntity entity){
		String result = service.addUser(entity);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public String authenticateGetToken(@RequestBody AuthDetails info) {
		Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(info.getUserName(), info.getUserPass()));
		if(authenticate.isAuthenticated()) {
			return jwtServices.generateAuthenticationToken(info.getUserName());
		}
		throw new UsernameNotFoundException("Invalid user Request...!");
	}
}
