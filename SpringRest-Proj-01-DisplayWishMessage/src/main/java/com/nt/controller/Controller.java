package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController=(@Controller+@ResponseBody)
public class Controller {

	private LocalDateTime ldt;
	
	@GetMapping("/generate")
	 ResponseEntity<String> showMessage(){
		ldt=LocalDateTime.now();
		 int hour  = ldt.getHour();
		 String msg=null;
		 if(hour<=12)
			 msg="Good Morning";
		 else if(hour<=16)
			 msg="Good Afternoon";
		 else if(hour<=20)
			 msg="Good Evening";
		 else
			 msg="Good night";
		 HttpStatus status = HttpStatus.OK;
		 return new ResponseEntity<>(msg, status);
	 }
}
