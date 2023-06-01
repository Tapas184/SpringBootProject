package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.dao.EmployeeDao;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private EmployeeDao dao;
	@Override
	public void run(String... args) throws Exception {
		dao.saveEmployee();

	}

}
