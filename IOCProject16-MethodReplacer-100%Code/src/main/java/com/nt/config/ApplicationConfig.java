//100% Code configuration 
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages= "com.nt")
@ImportResource("com/nt/cfg/applicationContext.xml") // annotation for ImportXML File to 100% code driven
public class ApplicationConfig {

}
