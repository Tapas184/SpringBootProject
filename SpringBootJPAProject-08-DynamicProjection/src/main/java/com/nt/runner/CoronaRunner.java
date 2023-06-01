//Developing client code using spring boot runners
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.View1;
import com.nt.type.View2;
import com.nt.type.View3;

@Component
public class CoronaRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			service.searchVacineByCountry("India", View1.class)
					.forEach(v1 -> System.out.println(v1.getCountry() + "-" + v1.getName()));
			System.out.println("============View1-Class================");
			service.searchVacineByCountry("USA", View2.class)
					.forEach(v2 -> System.out.println(v2.getRegNo() + "-" + v2.getRequiredDoseCount()));
			System.out.println("================View2-Class================");
			service.searchVacineByCountry("Rusia", View3.class)
					.forEach(v3 -> System.out.println(v3.getCountry() + "-" + v3.getName() + "-" + v3.getPrice()));
			System.out.println("==============View3-class===================");
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}// run
}// class
