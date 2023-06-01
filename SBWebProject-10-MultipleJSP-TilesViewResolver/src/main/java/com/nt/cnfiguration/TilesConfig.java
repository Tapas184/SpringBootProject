package com.nt.cnfiguration;

import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.impl.BasicTilesContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Component
public class TilesConfig extends WebMvcConfigurationSupport {
	
	@Bean
	 BasicTilesContainer create() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("src\\main\\webapp\\WEB-INF\\titles.xml");
		//bean factory object
		BasicTilesContainer configure = new BasicTilesContainer(); //creates a basicTilesContainer class
		configure.setDefinitionsFactory((DefinitionsFactory) ctx);//
		return configure;
	}
	@Bean
	InternalResourceViewResolver createinternalRVR() {
		return new InternalResourceViewResolver();
	}

}
