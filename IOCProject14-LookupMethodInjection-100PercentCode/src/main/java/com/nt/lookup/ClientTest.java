package com.nt.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.cricketrs.Crickter;

public class ClientTest {

    public static void main(String[] args) {
	//creating IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	//creating Crickter class object
	Crickter cricket = ctx.getBean("cktr",Crickter.class);
	cricket.batting();
	cricket.bowling();
	//close IOC container
	ctx.close();
    }

}
