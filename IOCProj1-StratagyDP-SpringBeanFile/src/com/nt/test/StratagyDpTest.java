package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.nt.component.Flipkart;

public class StratagyDpTest {

    public static void main(String[] args) {

	//create IOC container
	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("com/nt/cfg/application_context.xml");
	//get Targetclass object
	Flipkart fpkt = factory.getBean("fqkt",Flipkart.class);
	//invok the Business Method
	String result = fpkt.shoping(new String[] {"Tshirt","Paint"},new float[] { 100.0f,1000.0f});
	System.out.println(result);
    }

}
