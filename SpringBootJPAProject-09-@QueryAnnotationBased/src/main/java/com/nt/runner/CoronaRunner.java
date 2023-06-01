//Developing client code using spring boot runners
package com.nt.runner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class CoronaRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			/*service.fetchByName("Covishild").forEach(System.out::println);
			service.fetchByName("Pyzer").forEach(System.out::println);
			*/
			//service.fetchByPrice(400.0, 587.0).forEach(System.out::println);
			/*service.fetchByCompany("Pyzer", "Russie").forEach(obj->{
				System.out.println(obj[0]+" "+obj[1]+" "+obj[2]);
			});*/
			/*service.fetchByCompany("Pyzer", "Russie").forEach(obj->{
				for(Object v1:obj) 
					System.out.print(v1+" ");
				System.out.println("\n---------");
			});*/
			service.fetchByPriceRange(400.0, 600.0).forEach(System.out::println);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}// run
}// class
