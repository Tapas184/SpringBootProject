package com.nt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristService;

@RestController
public class TouristController {
	@Autowired
	private ITouristService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) throws Exception{
		
		String msg=service.registerTourist(tourist);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}//method
	@GetMapping("/findtourist")
	public ResponseEntity<Object> findTourist() throws Exception{
			//get the tourist list by calling service method
			List<Tourist> touristList= service.fetchAllTourist();
			//return the list of tourist List and status message
		return new ResponseEntity<>(touristList,HttpStatus.OK);
	}//method
	@PutMapping("/updatetourist")
	public ResponseEntity<Object> updateTourist(@RequestBody Tourist tourist) throws Exception{
		
			//call the service class method
			String msg=service.updateTourist(tourist);
			//set the ResponseEntity msg and http status
			return new ResponseEntity<>(msg,HttpStatus.OK);
	}//end method
	@GetMapping("/findtourist/{id}")
	public ResponseEntity<Object> findTourist(@PathVariable("id") Integer id) throws Exception{
		//call the service message
			Tourist tourist = service.getById(id);
			return new ResponseEntity<>(tourist,HttpStatus.OK);
	}
}//end of the class TouristController
