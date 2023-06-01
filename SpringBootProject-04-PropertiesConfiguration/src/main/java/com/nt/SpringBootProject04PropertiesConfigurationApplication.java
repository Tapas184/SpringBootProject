package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.BillGenerator;

@SpringBootApplication
public class SpringBootProject04PropertiesConfigurationApplication {

	public static void main(String[] args) {
		// create IOC container
		ApplicationContext ctx = SpringApplication.run(SpringBootProject04PropertiesConfigurationApplication.class,
				args);
		BillGenerator bills = ctx.getBean("bill", BillGenerator.class);
		System.out.println("Total is :: " + bills);
		((ConfigurableApplicationContext) ctx).close();
	}
}
