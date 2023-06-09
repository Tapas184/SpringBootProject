package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringRestProj04ConsumerAppApplication {

	@Bean
	 RestTemplate createTemplate() {
		return new RestTemplate();
	}
	@Bean
	ObjectMapper createObjectmapper() {
		return new  ObjectMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj04ConsumerAppApplication.class, args);
	}

}
