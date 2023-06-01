//Developing client code using spring boot runners
package com.nt.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVacine;
import com.nt.service.ICoronaVaccineMgmtService;
@Component
public class CoronaRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		try {
			//service.fetchByPrice(400.0).forEach(System.out::println);
			service.fetchByCounty(List.of("India","USA")).forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}//run
}//class
