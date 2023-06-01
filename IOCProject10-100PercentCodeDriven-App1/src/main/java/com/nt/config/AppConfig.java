//AppConfiguration bt 100% code driven
package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nt.beans") // atter native <context:component-scan>
public class AppConfig {
    
    @Bean(name = "ldt")
    public LocalDateTime createLocalDateTime() {
	LocalDateTime ldt =  LocalDateTime.now(); // gives System date and  time
	return ldt;
    }
}
