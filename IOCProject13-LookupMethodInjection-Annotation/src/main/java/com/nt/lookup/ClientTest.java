package com.nt.lookup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.cricketrs.Crickter;

public class ClientTest {

    public static void main(String[] args) {
	//creating IOC container
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
	//creating Crickter class object
	Crickter cricket = ctx.getBean("cktr",Crickter.class);
	cricket.batting();
	cricket.bowling();
	//close IOC container
	ctx.close();
    }

}
