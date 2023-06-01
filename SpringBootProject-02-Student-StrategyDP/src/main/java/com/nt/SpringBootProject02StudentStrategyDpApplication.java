//client class
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.TStudent;

@SpringBootApplication
@ImportResource("com/nt/cfg/applicationContext.xml")
public class SpringBootProject02StudentStrategyDpApplication {

	public static void main(String[] args) {
		//IOC container creation
		ApplicationContext ctx =SpringApplication.run(SpringBootProject02StudentStrategyDpApplication.class, args);
		//get target class using IOC 
	TStudent st	=ctx.getBean("student",TStudent.class);
	//invoke b.method
	st.preparation("java");
	//close IOC container
	((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
