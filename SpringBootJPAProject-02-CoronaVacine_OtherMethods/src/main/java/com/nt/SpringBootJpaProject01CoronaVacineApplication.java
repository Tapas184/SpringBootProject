package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.NonTransientDataAccessException;

import com.nt.entity.CoronaVacine;
import com.nt.service.CoronaMgmtService;
import com.nt.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringBootJpaProject01CoronaVacineApplication {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=  SpringApplication.run(SpringBootJpaProject01CoronaVacineApplication.class, args);
		/*		//create service class object
				ICoronaVaccineMgmtService service = ctx.getBean("coronaService",ICoronaVaccineMgmtService.class);
				//invok the business method
				try {
					CoronaVacine vaccine = new CoronaVacine(null,"Covishild","India-BioTech","India",400.0,5);
					System.out.println(service.registerVaccine(vaccine));
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}//catch
		*/		((ConfigurableApplicationContext) ctx).close();
	}//main method

}
