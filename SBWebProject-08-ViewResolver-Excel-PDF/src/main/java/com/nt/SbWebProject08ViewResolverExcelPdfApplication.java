package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class SbWebProject08ViewResolverExcelPdfApplication {
	//make this java bean
	@Bean
	public  BeanNameViewResolver createBNVR() {
		//for checking purpose
		System.out.println("SbWebProject08ViewResolverExcelPdfApplication.Created"); 
		//create Bean Name viewresolver object
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
		//(It internally reached the one and other view resolver with the LVN with
		//received from Handler method)
	}

	public static void main(String[] args) {
		SpringApplication.run(SbWebProject08ViewResolverExcelPdfApplication.class, args);
	}

}
