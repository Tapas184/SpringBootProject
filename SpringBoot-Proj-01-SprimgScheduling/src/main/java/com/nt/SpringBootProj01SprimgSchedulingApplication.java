package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootProj01SprimgSchedulingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootProj01SprimgSchedulingApplication.class, args);
		System.out.println("App started"+new Date());
	}

}
