package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.DemoEntity;
import com.demo.repo.DemoRepo;

@Service
public class DemoService {

	@Autowired
	private DemoRepo demoRepo;
	
	public String createDemo(DemoEntity entity) {
		
		DemoEntity demoEntity = demoRepo.save(entity);
		return "SuccessFully created"+demoEntity.getId();
		
	}
	
	public Optional<DemoEntity> getObject(Integer id){
		return demoRepo.findById(id);
	}
}
