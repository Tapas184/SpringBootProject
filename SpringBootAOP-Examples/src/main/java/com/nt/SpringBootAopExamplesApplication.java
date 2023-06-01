package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // for enable AOP configuration
public class SpringBootAopExamplesApplication {
		public static void main(String[] args) {
		SpringApplication.run(SpringBootAopExamplesApplication.class, args);
	}

}
