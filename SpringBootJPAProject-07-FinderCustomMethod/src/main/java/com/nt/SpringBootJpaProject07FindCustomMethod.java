//Static Projection...............
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
public class SpringBootJpaProject07FindCustomMethod {

	public static void main(String[] args) {
		//create IOC container
		SpringApplication.run(SpringBootJpaProject07FindCustomMethod .class, args);
	}//main method

}
