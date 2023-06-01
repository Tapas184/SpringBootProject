package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class TestClass {

    public static void main(String[] args) {

	//create IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	//get Target class object
	WishMessageGenerator wmg = ctx.getBean("wmg",WishMessageGenerator.class);
	//invoke Business method
	try {
	    System.out.println(wmg.generatorWishMessage("Tapas"));
	}//try
	catch(Exception e) {
	    e.printStackTrace();
	}//catch
	ctx.close();
    }

}
