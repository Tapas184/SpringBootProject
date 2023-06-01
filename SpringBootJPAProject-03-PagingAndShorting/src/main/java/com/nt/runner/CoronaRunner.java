//Developing client code using spring boot runners
package com.nt.runner;


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
			/*//create a Iterable object by shorting the price
			Iterable<CoronaVacine> listEntity = service.fatchDetailsBy(true,"price","name");
			//print each object present in listEntity
			listEntity.forEach(System.out::println);*/
			System.out.println("===================Pagenation================");
			service.fatchDetailsByPageNo(2, 2, true, "name").forEach(System.out::println);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
	}

}
