package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class SpringBootProject06PropertiesfileAndYmlFileApplication {

	public static void main(String[] args) {
	ApplicationContext ctx	=SpringApplication.run(SpringBootProject06PropertiesfileAndYmlFileApplication.class, args);
	Employee emp = ctx.getBean("employee",Employee.class);
	System.out.println(emp);
	((ConfigurableApplicationContext) ctx).close();
	}

}
