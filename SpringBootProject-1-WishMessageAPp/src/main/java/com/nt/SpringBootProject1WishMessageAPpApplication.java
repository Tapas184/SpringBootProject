package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class SpringBootProject1WishMessageAPpApplication {
	@Bean("ldt")
	public LocalDateTime localDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx =SpringApplication.run(SpringBootProject1WishMessageAPpApplication.class, args);
		//create WishMessageGenerator class object
		WishMessageGenerator ganerator = ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke generator method
		String msg = ganerator.ganeratorMessage("Tapas");
		System.out.println(msg);
	}

}
