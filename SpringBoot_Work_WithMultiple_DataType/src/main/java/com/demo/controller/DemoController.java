package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.DemoEntity;
import com.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	public DemoService service;
	
	@PostMapping("/adddemo")
	public ResponseEntity<String> addDemo(@RequestBody DemoEntity body){
		String createDemo = service.createDemo(body);
		return ResponseEntity.ok(createDemo);
	}
	
	@GetMapping("/getDemo/{id}")
	public ResponseEntity<DemoEntity> getDemoObject(@PathVariable("id") Integer id){
		Optional<DemoEntity> object = service.getObject(id);
		DemoEntity entity = null;
		if(object.isPresent()) {
			entity=object.get();
		}
		return ResponseEntity.ok(entity);
	}
}
