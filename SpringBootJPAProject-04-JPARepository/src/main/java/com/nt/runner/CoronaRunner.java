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
			/*//CoronaVacine vacine = new CoronaVacine("Rusia","Pyzer","rush",506.9,2);
			//for one criteria
			CoronaVacine vacine = new CoronaVacine();
			vacine.setCountry("India");
			service.serchVacineByGivenData(vacine, true, "name").forEach(System.out::println);*/
			/*			CoronaVacine vacine = service.getVacineByRegNo(55L);
						if(vacine!=null)
							System.out.println("Vacine details :: "+vacine);
						else
							System.out.println("Vacine not availabe");*/
			System.out.println("=============================");
			System.out.println(service.removeVaccineByRegNo(List.of(52L,1L)));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}//run
}//class
