package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Company;
import com.nt.beans.Company1;

@SpringBootApplication
public class SpringBootProject05PropertiesConfigurationwithPrefixApplication {

	public static void main(String[] args) {
		//create IOC container
	ApplicationContext ctx=	SpringApplication.run(SpringBootProject05PropertiesConfigurationwithPrefixApplication.class, args);
	Company company = ctx.getBean("company",Company.class);
	System.out.println(company);
	System.out.println("==========================");
	Company1 company1 = ctx.getBean("company1",Company1.class);
	System.out.println(company1);
	((ConfigurableApplicationContext) ctx).close();
	}

}
