package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.component.Flipkart;

public class StratagyDpTest {

    public static void main(String[] args) {

	//create IOC container
	/*DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("com/nt/cfg/application_context.xml");*/
	ClassPathXmlApplicationContext ctx = new 
		ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
	//get Targetclass object
	Flipkart fpkt = ctx.getBean("fkt",Flipkart.class);
	//invok the Business Method
	String result = fpkt.shoping(new String[] {"Tshirt","Paint"},new float[] {100.0f,1000.0f});
	System.out.println(result);
    }

}
